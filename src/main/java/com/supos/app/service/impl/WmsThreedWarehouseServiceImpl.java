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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

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
    @Value("${mqtt.topic_full}")
    private String mqttTopicFull;

    @Value("${mqtt.topic_increment}")
    private String mqttTopicIncrement;

    @Autowired
    WmsThreedWarehouseMapper wmsThreedWarehouseMapper;

    /* MQTT json string to Unity
    {
        "material": "SR20VET",
        "location": "A-01-A2"
    }
    */
    public int updateSelectiveByLocationId(WmsThreedWarehouse wmsThreedWarehouse) {
        Gson gson = new Gson();
        Map<String, Object> jsonData = new HashMap<>();
        jsonData.put("material", wmsThreedWarehouse.getMaterial_name());
        jsonData.put("location", wmsThreedWarehouse.getLocation_name());
        String content = gson.toJson(jsonData);
        int qos = 2;
        sendMqttToUnity(content, qos);
        return wmsThreedWarehouseMapper.updateSelectiveByLocationId(wmsThreedWarehouse);
    }

    @PostConstruct
    public void initSubscribeMqtt() {

        try {
            MqttClient client = new MqttClient(mqttBroker, mqttClientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            client.connect(connOpts);

            System.out.println("Connected to broker: " + mqttBroker);
            log.info("Connected to broker: {}", mqttBroker);

            // Subscribe to the request topic
            client.subscribe(mqttTopicFull, 2); // Using QoS 2 for example

            // Set callback to handle messages
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    // Handle connection lost
                    log.error("Connected to lost: {}", mqttBroker);
                }

                /* MQTT json string to Unity
                    [{"material": "SR20VET", "location": "A-01-A2"}, {"material": "VQ35DE", "location": "A-01-A3"}]
                */
                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    // This method is called when a message arrives from the server.
                    System.out.println("Received request: " + new String(message.getPayload()));

                    // Return all material name and storage location name mapping list as response
                    List<WmsThreedWarehouse> listAll = wmsThreedWarehouseMapper.selectAllStocked();
                    List<Map<String, Object>> listOfMaps = new ArrayList<>();

                    for (WmsThreedWarehouse wmsThreedWarehouse : listAll) {
                        Map<String, Object> jsonData = new HashMap<>();
                        jsonData.put("material", wmsThreedWarehouse.getMaterial_name());
                        jsonData.put("location", wmsThreedWarehouse.getLocation_name());
                        listOfMaps.add(jsonData);
                    }

                    Gson gson = new Gson();
                    String content = gson.toJson(listOfMaps);
                    // Publish the response to the response topic
                    MqttMessage responseMessage = new MqttMessage(content.getBytes());
                    responseMessage.setQos(2); // Matching QoS for example
                    client.publish(mqttTopicFull, responseMessage);

                    System.out.println("Response published to topic: " + mqttTopicFull);
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                    // Not needed for subscribers
                }
            });

            // Keep the application running to listen for requests
            System.out.println("Subscribed to request topic. Awaiting requests...");
            Thread.sleep(0); // Adjust as necessary

            client.disconnect();
            System.out.println("Disconnected");

        } catch(MqttException | InterruptedException me) {
            System.err.println("Error: " + me.getMessage());
            me.printStackTrace();
        }
    }

    public void sendMqttToUnity(String content, int qos) {
        try {
            MqttClient sampleClient = new MqttClient(mqttBroker, mqttClientId);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + mqttBroker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Publishing message: " + content);
            MqttMessage message = new MqttMessage(content.getBytes());
            message.setQos(qos);
            sampleClient.publish(mqttTopicIncrement, message);
            System.out.println("Message published");
            sampleClient.disconnect();
            System.out.println("Disconnected");
            System.exit(0);
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




