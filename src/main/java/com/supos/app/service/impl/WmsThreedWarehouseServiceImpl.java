package com.supos.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.supos.app.config.MinioConfig;
import com.supos.app.entity.WmsStorageLocation;
import com.supos.app.entity.WmsThreedWarehouse;
import com.supos.app.impl.MinioUtil;
import com.supos.app.mapper.WmsWarehouseMapper;
import com.supos.app.service.WmsThreedWarehouseService;
import com.supos.app.mapper.WmsThreedWarehouseMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

import javax.annotation.PostConstruct;
import com.google.gson.Gson;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
* @author Wenhao
* @description 针对表【wms_threed_warehouse】的数据库操作Service实现
* @createDate 2024-03-28 17:03:15
*/
@Slf4j
@Service
public class WmsThreedWarehouseServiceImpl extends ServiceImpl<WmsThreedWarehouseMapper, WmsThreedWarehouse>
    implements WmsThreedWarehouseService{

    @Value("${mqtt.broker}")
    private String mqttBroker;

    @Value("${mqtt.clientId}")
    private String mqttClientId;
    @Value("${mqtt.topic_full_request}")
    private String mqttTopicFullRequest;

    @Value("${mqtt.topic_full_response}")
    private String mqttTopicFullResponse;

    @Value("${mqtt.topic_increment}")
    private String mqttTopicIncrement;

    @Autowired
    WmsThreedWarehouseMapper wmsThreedWarehouseMapper;

    MqttClient mqttClient;

    private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    @Autowired
    WmsStorageLocationServiceImpl wmsStorageLocationServiceImpl;

    // MQTT json string to Unity, inbound: {"material": "SR20VET", "location": "A-01-A2"}, outbound: {"location": "A-01-A2"}
    public int updateSelectiveByLocationId(WmsThreedWarehouse wmsThreedWarehouse) {
        String locationName = "";
        WmsStorageLocation wmsStorageLocation = new WmsStorageLocation();
        wmsStorageLocation.setId(wmsThreedWarehouse.getLocation_id());
        List<WmsStorageLocation> storageLocations = wmsStorageLocationServiceImpl.selectAll(wmsStorageLocation);
        if (!storageLocations.isEmpty()) {
            locationName = storageLocations.get(0).getName();
        }
        Gson gson = new Gson();
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("material", wmsThreedWarehouse.getMaterial_name());
        jsonData.put("location", locationName);
        // Wrap your map inside a list to form a single-element array
        String content = gson.toJson(Collections.singletonList(jsonData));
        int qos = 2;
        sendMqttToUnity(content, qos);
        return wmsThreedWarehouseMapper.updateSelectiveByLocationId(wmsThreedWarehouse);
    }

    private void scheduleReconnect() {
        scheduler.schedule(() -> {
            if (!mqttClient.isConnected()) {
                try {
                    log.info("Attempting to reconnect to the MQTT broker...");
                    mqttClient.connect(new MqttConnectOptions());
                    log.info("Reconnected to the MQTT broker.");
                    // Resubscribe to necessary topics after reconnection
                    mqttClient.subscribe(mqttTopicFullRequest, 2);
                    log.info("Resubscribed to topic: {}", mqttTopicFullRequest);
                } catch (MqttException me) {
                    log.error("Reconnection attempt failed", me);
                    // Schedule another reconnect if the first reconnect fails
                    scheduleReconnect();
                }
            }
        }, 5, TimeUnit.SECONDS);
    }

    @PostConstruct
    public void initSubscribeMqtt() {

        try {
            mqttClient = new MqttClient(mqttBroker, mqttClientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            mqttClient.connect(connOpts);

            System.out.println("Connected to broker: " + mqttBroker);
            log.info("Connected to broker: {}", mqttBroker);

            // Subscribe to the request topic
            mqttClient.subscribe(mqttTopicFullRequest, 2); // Using QoS 2 for example

            // Set callback to handle messages
            mqttClient.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    // Handle connection lost
                    log.error("Connected lost: {}", mqttBroker);
                    // Schedule a reconnection attempt
                    scheduleReconnect();
                }

                /* MQTT json string to Unity
                    [{"material": "SR20VET", "location": "A-01-A2"}, {"material": "VQ35DE", "location": "A-01-A3"}]
                */
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    // This method is called when a message arrives from the server.
                    System.out.println("Received request: " + new String(message.getPayload()));
                    log.info("Received request from topic: {}, content: {}", topic, new String(message.getPayload()));

                    // Return all material name and storage location name mapping list as response
                    List<WmsThreedWarehouse> listAll = wmsThreedWarehouseMapper.selectAllStocked();
                    List<Map<String, Object>> listOfMaps = new ArrayList<>();

                    //int count = 0; // Counter to track the number of added elements
                    for (WmsThreedWarehouse wmsThreedWarehouse : listAll) {
                        //if (count >= 2) break; // Stop after adding two elements

                        Map<String, Object> jsonData = new HashMap<>();
                        jsonData.put("material", wmsThreedWarehouse.getMaterial_name());
                        jsonData.put("location", wmsThreedWarehouse.getLocation_name());
                        listOfMaps.add(jsonData);

                        //count++; // Increment the counter
                    }

                    Gson gson = new Gson();
                    String content = gson.toJson(listOfMaps);
                    // Publish the response to the response topic
                    MqttMessage responseMessage = new MqttMessage(content.getBytes());
                    responseMessage.setQos(2); // Matching QoS for example
                    mqttClient.publish(mqttTopicFullResponse, responseMessage);

                    System.out.println("Response published to topic: " + mqttTopicFullResponse);
                    if (content.length() > 30) {
                        System.out.println("Publishing message of length: " + content.length() + " characters");
                        log.info("Response published to topic: {}, content json array size: {}", mqttTopicFullResponse, listOfMaps.size());
                    } else {
                        log.info("Response published to topic: {}, content: {}", mqttTopicFullResponse, content);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not needed for subscribers
                }
            });

            // Keep the application running to listen for requests
            System.out.println("Subscribe to topic: " + mqttTopicFullRequest);
            log.info("Subscribe to topic: {}", mqttTopicFullRequest);
            //Thread.sleep(0); // 这个影响开发时候启动，所以我先改成0后续有需求的话再改

        //} catch(MqttException | InterruptedException me) {
        } catch(MqttException me) {
            System.err.println("Error: " + me.getMessage());
            me.printStackTrace();
            log.error("Error: " + me.getMessage());
        }
    }

    public void sendMqttToUnity(String content, int qos) {
        try {
            if (content.length() > 30) {
                System.out.println("Publishing message of length: " + content.length() + " characters");
                log.info("Publishing message of length: " + content.length() + " characters");
            } else {
                System.out.println("Publishing message: " + content);
                log.info("Publishing message: " + content);
            }

            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            mqttClient.publish(mqttTopicIncrement, message);
            System.out.println("Message published");
        } catch(MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }

}
