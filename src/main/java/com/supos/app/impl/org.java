package com.supos.app.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.supos.app.aksk.SignUtils;
import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


//下面这部分是组织/人员管理接口调用用例
public class org {
//    public static void main(String[] args) {
//        persons();
//        System.out.println("前面是您自己的程序，想做啥就做啥。后面加上Supos的接口就可以同步了，veryEZ");
//        System.out.println("========================我是美丽的分割线============================");
//        for (int i = 0; i < 10; i++) {
////            addPerson("xxx"+i,"xxx"+i,"male","onWork","standard_position");
////            deletePersons("xxx"+i);
//        }
//    }

    public static void addPerson(String code, String name, String gender, String status, String mainPositionCode) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        String baseDomain = "http://192.168.31.223:8080";
        Map<String, String> headerMap = new HashMap<>(16);
        headerMap.put("X-MC-Type", "openAPI");
        headerMap.put("X-MC-Date", sf.format(new Date()));
        headerMap.put("Content-Type", "application/json;charset=utf-8");
        Map<String, String> queryMap = new HashMap<>(16);
        String uri = "/open-api/organization/v2/persons/bulk";
        String appId = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String appSecret = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String ak = "415ed3fc72b533713244dcd553159642";
        String sk = "10999785ab1c5f475c6d9c8b728e28a3";
        SignUtils signUtil = new SignUtils(appId, appSecret, ak, sk);
        headerMap.put("X-MC-AppId", "App_d0f7d746b28aeb634ed82e23f213bdb7");
        signUtil.signHeaderUseAkSk(uri, "POST", headerMap, queryMap);
        JSONObject jsonObject = new JSONObject();
        jsonObject.set("code", code);
        jsonObject.set("name", name);
        jsonObject.set("gender", gender);
        jsonObject.set("status", status);
        jsonObject.set("mainPositionCode", mainPositionCode);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(jsonObject);
        JSONObject entries = new JSONObject();
        entries.set("addPersons",jsonArray);
        System.out.println(entries);
        HttpResponse response = HttpRequest.post(baseDomain + "" + uri).body(entries.toStringPretty()).formStr(queryMap).headerMap(headerMap, true).execute();
        System.out.println(response);
    }

    public static void persons() {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        String baseDomain = "http://192.168.31.223:8080";
        Map<String, String> headerMap = new HashMap<>(16);
        headerMap.put("X-MC-Type", "openAPI");
        headerMap.put("X-MC-Date", sf.format(new Date()));
        headerMap.put("Content-Type", "application/json;charset=utf-8");
        Map<String, String> queryMap = new HashMap<>(16);
        queryMap.put("current", "1");
        queryMap.put("pageSize", "100");
        String uri = "/open-api/organization/v2/persons";
        String appId = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String appSecret = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String ak = "415ed3fc72b533713244dcd553159642";
        String sk = "10999785ab1c5f475c6d9c8b728e28a3";
        SignUtils signUtil = new SignUtils(appId, appSecret, ak, sk);
        headerMap.put("X-MC-AppId", "App_d0f7d746b28aeb634ed82e23f213bdb7");
        signUtil.signHeaderUseAkSk(uri, "GET", headerMap, queryMap);
        HttpResponse response = HttpRequest.get(baseDomain + "" + uri).formStr(queryMap).headerMap(headerMap, true).execute();
        System.out.println(response.body());
    }

    public static void deletePersons(String code) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        String baseDomain = "http://192.168.31.223:8080";
        Map<String, String> headerMap = new HashMap<>(16);
        headerMap.put("X-MC-Type", "openAPI");
        headerMap.put("X-MC-Date", sf.format(new Date()));
        headerMap.put("Content-Type", "application/json;charset=utf-8");
        Map<String, String> queryMap = new HashMap<>(16);
        String uri = "/open-api/organization/v2/persons/bulk";
        String appId = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String appSecret = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String ak = "415ed3fc72b533713244dcd553159642";
        String sk = "10999785ab1c5f475c6d9c8b728e28a3";
        SignUtils signUtil = new SignUtils(appId, appSecret, ak, sk);
        headerMap.put("X-MC-AppId", "App_d0f7d746b28aeb634ed82e23f213bdb7");
        signUtil.signHeaderUseAkSk(uri, "POST", headerMap, queryMap);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(code);
        JSONObject entries = new JSONObject();
        entries.set("deletePersons",jsonArray);
        System.out.println(entries);
        HttpResponse response = HttpRequest.post(baseDomain + "" + uri).body(entries.toStringPretty()).formStr(queryMap).headerMap(headerMap, true).execute();
        System.out.println(response);
    }


}