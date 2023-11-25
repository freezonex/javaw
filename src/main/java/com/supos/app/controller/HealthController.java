package com.supos.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supos.app.dto.sampleMailDto;
import com.supos.app.impl.SampleMail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.supos.app.impl.SampleMail.sendMail;


@Slf4j
@RestController
public class HealthController {

    @RequestMapping("/health")
    public String health() {
        log.info("App health check.");
        return "health";
    }

//    @GetMapping("/mail/{mail}")
//    public String mail(@PathVariable("mail") String mail) throws IOException {
//        sendMail(mail);
//        return "{\"result\":\"我执行完了，外瑞古达\"}";
//    }
//    @PostMapping("/example")
//    @CrossOrigin
//    @Async
//    public ResponseEntity<String> handlePostRequest(@RequestBody String requestBody) throws IOException {
//        // 处理POST请求的逻辑
//        String response = "Received POST request with body: " + requestBody;
////        System.out.println(requestBody);
//
//        JSONObject jsonObject = JSON.parseObject(requestBody);
//        System.out.println(jsonObject);
////        System.out.println(jsonObject.getString("image"));
//        for (int i = 0; i < jsonObject.size(); i++) {
////            System.out.println(JSONObject.parseObject(jsonObject.getString(String.valueOf(i))).getString("mail"));
//            sendMail(JSONObject.parseObject(jsonObject.getString(String.valueOf(i))).getString("mail"),JSONObject.parseObject(jsonObject.getString(String.valueOf(i))).getString("image"),JSONObject.parseObject(jsonObject.getString(String.valueOf(i))).getString("code"));
//        }
//        System.out.println("触发");
//        return ResponseEntity.ok(response);
//    }


    @PostMapping("/example")
    @CrossOrigin
    @Async
    public ResponseEntity<String> handlePostRequest(@RequestBody String requestBody) throws IOException {
        // 处理POST请求的逻辑
        JSONObject jsonObject = JSON.parseObject(requestBody);
        log.info("handlePostRequest入参 {}",jsonObject);

                String response = "Received POST request with body: " + requestBody;

        for (int i = 0; i < jsonObject.size(); i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            sampleMailDto mail = objectMapper.readValue(jsonObject.getString(String.valueOf(i)),sampleMailDto.class);
            sendMail(mail);
        }
        log.info("触发");
        return ResponseEntity.ok(response);
    }


    @PostMapping("/innerExample/cbscK6BDA8HCNg2Cgf60")
    @CrossOrigin
    @Async
    public ResponseEntity<String> handleInnerExamplePostRequest(@RequestBody String requestBody) throws IOException {
        // 处理POST请求的逻辑
        JSONArray jsonArray = JSON.parseArray(requestBody);
        log.info("handleInnerExamplePostRequest入参 {}",jsonArray);

        String response = "Received POST request with body: " + requestBody;

        for (int i = 0; i < jsonArray.size(); i++) {
            ObjectMapper objectMapper = new ObjectMapper();
            sampleMailDto mail = objectMapper.readValue(jsonArray.getJSONObject(i).toString(),sampleMailDto.class);
            sendMail(mail);
        }
        log.info("触发");
        return ResponseEntity.ok(response);
    }
}
