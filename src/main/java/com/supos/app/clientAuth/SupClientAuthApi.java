package com.supos.app.clientAuth;

import com.alibaba.fastjson.JSONObject;
import com.supos.app.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author chenfei
 * @Date 2021/4/14 13:07
 */
public class SupClientAuthApi {

    public static Token getClientToken(String suposAddress, String appId, String secretKey) {
        String path = suposAddress + "/oauth2/client/v1/accessToken";

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("grantType", "client_credential");
        queryParams.put("appid", appId);
        queryParams.put("secret", secretKey);

        String result = HttpUtils.doGet(path, queryParams);

        return JSONObject.parseObject(result, Token.class);
    }

    public static Token refreshClientToken(String suposAddress, Token token) {
        String path = suposAddress + "/oauth2/client/v1/refreshToken";

        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("refreshToken", token.getRefreshToken());

        String result = HttpUtils.doGet(path, queryParams);

        return JSONObject.parseObject(result, Token.class);
    }
}
