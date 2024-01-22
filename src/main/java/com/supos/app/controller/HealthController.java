package com.supos.app.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.supos.app.dto.sampleMailDto;
import com.supos.app.entity.SuposApi;
import com.supos.app.aksk.SignUtils;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.supos.app.impl.SampleMail.sendMail;


@Slf4j
@RestController
public class HealthController {

    @ApiOperation(value = "健康探针",notes = "健康探针")
    @GetMapping("/health")
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

    @ApiOperation(value = "suposApi",notes = "suposApi接口的说明")
    @PostMapping("/suposApi")
    public ResponseEntity.BodyBuilder suposApi(@RequestBody SuposApi suposApi){
        log.info(String.valueOf(suposApi));
        return  ResponseEntity.ok();
    }

    @ApiOperation(value = "算法",notes = "生成SuposAPIAuth")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "成功返回页面",response = SuposApi.class),
            @ApiResponse(code = 201, message = "我也懒得写"),
            @ApiResponse(code = 401, message = "未授权访问",response = SuposApi.class)
    })
    @ApiImplicitParams({@ApiImplicitParam(name = "suposApi", dataType = "SuposApi", required = true, paramType = "body")})
    @PostMapping("/crypto")
    public ResponseEntity<String> crypto(@ApiParam(hidden = true) @RequestBody String requestBody) throws JsonProcessingException {
        SuposApi suposApi = new ObjectMapper().readValue(requestBody, SuposApi.class);
        System.out.println(suposApi);
        return ResponseEntity.ok(SignUtils.signHeaderUseAkSkWithInput(suposApi.getUri(),suposApi.getMethodName(),suposApi.getHeaderJson(),suposApi.getQueryJson(),suposApi.getAk(),suposApi.getSk()));
    }

    @ApiOperation(value = "外部",notes = "外部邮件发送")
    @PostMapping("/example")
    @CrossOrigin
    @Async
    @ApiImplicitParams({@ApiImplicitParam(name = "suposApi", dataType = "SuposApi", required = true, paramType = "body")})
    public ResponseEntity<String> handlePostRequest(@ApiParam(hidden = true) @RequestBody String requestBody) throws IOException {
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

    @ApiOperation(value = "内部",notes = "内部邮件发送")
    @PostMapping("/innerExample/cbscK6BDA8HCNg2Cgf60")
    @CrossOrigin
    @Async
    @ApiImplicitParams({@ApiImplicitParam(name = "suposApi", dataType = "SuposApi", required = true, paramType = "body")})
    public ResponseEntity<String> handleInnerExamplePostRequest(@ApiParam(hidden = true) @RequestBody String requestBody) throws IOException {
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
