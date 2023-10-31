package com.supos.app.impl;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONObject;
import com.supos.app.aksk.SignUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class workFlow {

    //这是一个工作流发起用例
    public static void main(String[] args) {
        SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        String baseDomain = "http://192.168.31.223:8080";
        Map<String, String> headerMap = new HashMap<>(16);
        headerMap.put("X-MC-Type", "openAPI");
        headerMap.put("X-MC-Date", sf.format(new Date()));
        headerMap.put("Content-Type", "application/json;charset=utf-8");
        Map<String, String> queryMap = new HashMap<>(16);
        String uri = "/open-api/p/workflow/v2/processes";
        String appId = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String appSecret = "App_d0f7d746b28aeb634ed82e23f213bdb7";
        String ak = "415ed3fc72b533713244dcd553159642";
        String sk = "10999785ab1c5f475c6d9c8b728e28a3";
        SignUtils signUtil = new SignUtils(appId, appSecret, ak, sk);
        headerMap.put("X-MC-AppId", "App_d0f7d746b28aeb634ed82e23f213bdb7");
        signUtil.signHeaderUseAkSk(uri, "POST", headerMap, queryMap);
        JSONObject body = new JSONObject();
        body.set("processKey","K3851202564029313");
        body.set("username","admin");
        JSONObject entrie = new JSONObject();
        entrie.set("name_0","测试");
        body.set("formData",entrie.toString());
        System.out.println(body);
        HttpResponse response = HttpRequest.post(baseDomain + "" + uri).body(body.toStringPretty()).formStr(queryMap).headerMap(headerMap, true).execute();
        System.out.println(response);
    }


}
