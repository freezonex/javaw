package com.supos.app.aksk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.supos.app.clientAuth.SupClientAuthApi;
import com.supos.app.supopenapi.SupOpenApi;
import com.supos.app.clientAuth.Token;
import com.supos.app.config.AppConfig;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * AK/SK 签名工具类
 */
@Slf4j
@Component
public class SignUtil {

    @Autowired
    private AppConfig appConfig;

    private static String APP_ID;
    private static String SECRET_KEY;

    private static String SUPOS_ADDRESS;

    private final static String OPEN_API_URL = "http://192.168.31.223:8000";

    @PostConstruct
    public void init() {
        SignUtil.APP_ID = StringUtils.isEmpty(System.getenv("SUPOS_SUPOS_APP_ACCOUNT_ID")) ?
                appConfig.getAppId() : System.getenv("SUPOS_SUPOS_APP_ACCOUNT_ID");
        SignUtil.SECRET_KEY = StringUtils.isEmpty(System.getenv("SUPOS_SUPOS_APP_SECRET_KEY")) ?
                appConfig.getAppSecret() : System.getenv("SUPOS_SUPOS_APP_SECRET_KEY");
        SignUtil.SUPOS_ADDRESS = appConfig.getSuposWebAddress();
    }

    /**
     * 通过AK/SK签名 发送HTTP请求调用open api接口
     * <p>部署在supOS k8s环境内部的应用，可以直接调用这个方法</p>
     *
     * @param apiPath  api的请求路径 如:/openapi/users/v1?page=1&per_page=2
     * @param method   HttpMethod
     * @param jsonBody 当method是post put等请求时，所携带的body
     * @return 接口返回
     * @throws Exception e
     */
    public static String doHttpMethod(String apiPath, HttpMethod method, JSONObject jsonBody, Map<String, String> headerMap) throws Exception {
        return doHttpMethod(OPEN_API_URL, apiPath, method, jsonBody, headerMap);
    }

    /**
     * 通过AK/SK签名 发送HTTP请求调用open api接口
     *
     * @param apiBaseURL api的域名或者ip + port
     * @param apiPath    api的请求路径 如:/openapi/users/v1?page=1&per_page=2
     * @param method     HttpMethod
     * @param jsonBody   当method是post put等请求时，所携带的body
     * @return 接口返回
     * @throws Exception e
     */
    public static String doHttpMethod(String apiBaseURL, String apiPath, HttpMethod method, JSONObject jsonBody,
                                      Map<String, String> headerMap) throws Exception {
        log.debug(">>>>>>>>>>>>> AK/SK 请求 apiBaseURL: {} , apiPath: {} , method: {} ,jsonBody: {} <<<<<<<<<<<<<<<<",
                apiBaseURL, apiPath, method, jsonBody);
        SignRequest request = new SignRequest();
        request.setUrl(apiBaseURL, apiPath);
        request.setAppKey(APP_ID);
        request.setAppSecret(SECRET_KEY);
        request.setHttpMethod(method);
        if (!CollectionUtils.isEmpty(headerMap)) {
            for (Map.Entry<String, String> entry : headerMap.entrySet()) {
                request.addHeader(entry.getKey(), entry.getValue());
            }
        }
        if (StringUtils.isEmpty(request.getHeaders().get(HttpHeaders.CONTENT_TYPE))) {
            request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");
        }
        if (null != jsonBody) {
            request.setBody(jsonBody.toString());
        }
        HttpRequestBase requestBase = createSignatureRequest(request);
        CloseableHttpClient client = HttpClients.custom().build();
        HttpResponse response = client.execute(requestBase);
        int statusCode = response.getStatusLine().getStatusCode();
        HttpEntity resEntity = response.getEntity();
        String result = null;
        if (resEntity != null) {
            result = EntityUtils.toString(resEntity, "UTF-8");
        }
        log.debug(">>>>>>>>>>>>> AK/SK 响应状态码: {} , 响应内容: {} <<<<<<<<<<<<<<<<", statusCode, result);
        return result;
    }

    /**
     * 创建一个具有AKSK签名的HTTP CLIENT请求
     *
     * @param request 加签参数
     * @return HttpRequestBase
     */
    private static HttpRequestBase createSignatureRequest(SignRequest request) {
        HttpRequestBase httpRequest; StringEntity entity; HttpMethod httpMethod = request.getHttpMethod();
        String content = request.getBody(); String url = request.getUrl();
        if (httpMethod == HttpMethod.POST) {
            HttpPost postMethod = new HttpPost(url);
            if (StringUtils.isNotEmpty(content)) {
                entity = new StringEntity(content, StandardCharsets.UTF_8);
                postMethod.setEntity(entity);
            }
            httpRequest = postMethod;
        } else if (httpMethod == HttpMethod.PUT) {
            HttpPut putMethod = new HttpPut(url);
            httpRequest = putMethod;
            if (StringUtils.isNotEmpty(content)) {
                entity = new StringEntity(content, StandardCharsets.UTF_8);
                putMethod.setEntity(entity);
            }
        } else if (httpMethod == HttpMethod.PATCH) {
            HttpPatch patchMethod = new HttpPatch(url);
            httpRequest = patchMethod;
            if (StringUtils.isNotEmpty(content)) {
                entity = new StringEntity(content, StandardCharsets.UTF_8);
                patchMethod.setEntity(entity);
            }
        } else if (httpMethod == HttpMethod.GET) {
            httpRequest = new HttpGet(url);
        } else if (httpMethod == HttpMethod.DELETE) {
            httpRequest = new HttpDelete(url);
        } else if (httpMethod == HttpMethod.OPTIONS) {
            httpRequest = new HttpOptions(url);
        } else {
            if (httpMethod != HttpMethod.HEAD) {
                throw new RuntimeException("Unknown HTTP method name: " + httpMethod);
            }
            httpRequest = new HttpHead(url);
        }
        Map<String, String> headers = getSignatureHeader(request);
        Iterator<String> iterator = headers.keySet().iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            httpRequest.addHeader(key, headers.get(key));
        }
        return httpRequest;
    }

    /**
     * 获取AK/SK加签后的签名头
     *
     * @param request 加签参数
     * @return headers
     */
    public static Map<String, String> getSignatureHeader(SignRequest request) {
        Map<String, String> headers = request.getHeaders();
        //签名源
        StringBuffer sb = new StringBuffer();
        //HttpMethod
        sb.append(request.getHttpMethod()).append("\n");
        //HTTP URI
        sb.append(request.getSignUrl()).append("\n");
        //HTTPContentType
        sb.append(headers.get(HttpHeaders.CONTENT_TYPE)).append("\n");
        //CanonicalQueryString
        if (StringUtils.isNotEmpty(request.getQueryString())) {
            sb.append(request.getQueryString());
        }
        sb.append("\n");
        //CustomHeaders 自定义头  直接换行
        sb.append("\n");
        //log.info(">>>>>>>>>>>>> AK/SK 签名源内容：[{}] <<<<<<<<<<<<<<<<", sb);
        HmacUtils hmacSha256 = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, request.getSecrect());
        String signature = hmacSha256.hmacHex(sb.toString());
        String finalSignature = "Sign " + request.getKey() + "-" + signature;
        if (StringUtils.isEmpty(request.getHeaders().get(HttpHeaders.AUTHORIZATION))) {
            headers.put("Authorization", finalSignature);
        } else {
            headers.put("Authorization", request.getHeaders().get(HttpHeaders.AUTHORIZATION));
        }

        log.debug(">>>>>>>>>>>>> AK/SK 签名结果：{} <<<<<<<<<<<<<<<<", finalSignature);
        return headers;
    }

//    public static void run27() throws Exception {
//        String apiBaseURL = "http://ess-pgx3.devcloud.supos.net";
//
//        // Step1 : 获取supOS的对象的属性值
//        Token clientToken = SupClientAuthApi.getClientToken(apiBaseURL, APP_ID, SECRET_KEY);
//        for (int i = 0; i <= 5000; i++) {
//            JSONObject response = SupOpenApi.getSuposObjectPropertyCurrent(apiBaseURL, clientToken.getAccessToken());
//            log.debug("get data response : " + response);
//            // 响应结果：{"tower.upperTemperature":0.7087967357703808,"tower.lowerTemperature":0.4032736632473878}
//
//            // Step2 : 计算出当前冷却系统的输出功率的一个权重参数
//            Double upperTemperatureValue = response.getDouble("tower.upperTemperature");
//            Double lowerTemperatureValue = response.getDouble("tower.lowerTemperature");
//            // 算法（（上层温度*1.1 + 下层温度* 0.9）/ 2），计算出当前冷却系统的输出功率的一个权重参数
//            Double outputWeight = (upperTemperatureValue * 1.1 + lowerTemperatureValue * 0.9) / 2;
//            BigDecimal bg = new BigDecimal(outputWeight);
//            outputWeight = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//            log.info("上层温度:{}, 下层温度:{}, 功率输出指标系数:{}", upperTemperatureValue, lowerTemperatureValue, outputWeight);
//
//            // Step3 : 给supOS的对象的属性设值
//            JSONObject response2 = SupOpenApi.setSuposObjectPropertyCurrent(apiBaseURL, clientToken.getAccessToken(), outputWeight);
//            log.debug("set data response : " + response2);
//            // 响应结果：{"result":true}
//
//            Thread.sleep(1000);
//        }
//    }

    /**
     * 业务代码
     * Step1 : 获取supOS的对象（蒸馏塔）的属性（上下层温度）值
     * Step2 : 计算出当前冷却系统的输出功率的一个权重参数
     * Step3 : 给supOS的对象（冷却泵）的属性（outerWeigh）设值
     *
     * @throws Exception
     */
//    public static void run30() throws Exception {
//        // 接口名称： 查询对象属性的实时数据
//        // 入参：
//        // {
//        //  "inputs": [
//        //    "system.t1.instance.system.p1"
//        //  ]
//        // }
//        // 说明：支持批量查询，多个属性以逗号隔开
//        // 参数含义：命名空间.模板别名.对象实例别名.命名空间.属性别名
//        String bodyParam = "{\n" +
//                                "\t\"inputs\": \n" +
//                                "\t[" +
//                                "\t\"chenfei_apptest.tower_template.tower.chenfei_apptest.upperTemperature\" \n" +
//                                "\t\"chenfei_apptest.tower_template.tower.chenfei_apptest.lowerTemperature\" \n" +
//                                "\t]" +
//                            "}";
//        Map<String, String> headerParams = new HashMap<>();
//        headerParams.put(HttpHeaders.CONTENT_TYPE, "application/json");
//
//        String response = SignUtil.doHttpMethod(SUPOS_ADDRESS, "/open-api/supos/oodm/v2/attribute/current", HttpMethod.POST, JSON.parseObject(bodyParam), headerParams);
//        log.debug("get data response : " + response);
//        // return msg ：
//        //{
//        //	"code": 200,
//        //	"message": "ok",
//        //	"data": {
//        //		"chenfei_apptest.tower_template.tower.chenfei_apptest.upperTemperature": {
//        //			"name": "chenfei_apptest.tower_template.tower.chenfei_apptest.upperTemperature",
//        //			"value": 25.26609648789877,
//        //			"status": "0",
//        //			"timeStamp": 1618312132148
//        //		},
//        //		"chenfei_apptest.tower_template.tower.chenfei_apptest.lowerTemperature": {
//        //			"name": "chenfei_apptest.tower_template.tower.chenfei_apptest.lowerTemperature",
//        //			"value": 94.6812637716251,
//        //			"status": "0",
//        //			"timeStamp": 1618312132148
//        //		}
//        //	},
//        //	"detail": null
//        //}
//        JSONObject jbody = JSONObject.parseObject(response);
//        Double upperTemperatureValue = jbody.getJSONObject("data").getJSONObject("chenfei_apptest.tower_template.tower.chenfei_apptest.upperTemperature").getDouble("value");
//        Double lowerTemperatureValue = jbody.getJSONObject("data").getJSONObject("chenfei_apptest.tower_template.tower.chenfei_apptest.lowerTemperature").getDouble("value");
//
//        // 算法（（上层温度*1.1 + 下层温度* 0.9）/ 2），计算出当前冷却系统的输出功率的一个权重参数
//        Double outputWeight = (upperTemperatureValue * 1.1 + lowerTemperatureValue * 0.9) / 2;
//        BigDecimal bg = new BigDecimal(outputWeight);
//        outputWeight = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
//        log.info("上层温度:{}, 下层温度:{}, 功率输出指标系数:{}", upperTemperatureValue, lowerTemperatureValue, outputWeight);
//
//        // 接口名称： 向指定的对象的属性设置
//        // 入参：
//        // {
//        //  "outerWeigh": 0.12
//        // }
//        // 说明：支持多个属性值设置，多个属性以逗号隔开
//        // 参数含义：{属性别名: 属性值}
//        //
//        String bodyParam2 = "{\n" +
//                "\t\"outerWeigh\": \"" + outputWeight + "\" \n" +
//                "}";
//        String response2 = SignUtil.doHttpMethod(SUPOS_ADDRESS,
//                "/open-api/supos/oodm/v2/template/chenfei_apptest/tower_template/instance/pump/service/system/setPropertyValues",
//                HttpMethod.POST, JSON.parseObject(bodyParam2), headerParams);
//        log.debug("set data response : " + response2);
//        // return msg :
//        //{
//        //	"code": 200,
//        //	"message": "ok",
//        //	"data": {
//        //		"result": {
//        //			"success": true
//        //		}
//        //	},
//        //	"detail": null
//        //}
//
//        Thread.sleep(1000);
//        }

//
//    public static void main(String[] args) throws Exception {
//        //String apiBaseURL = "http://ess-ngd2.devcloud.supos.net";
//        String apiBaseURL = "http://ess-pgx3.devcloud.supos.net";
//
//        Token clientToken = SupClientAuthApi.getClientToken(apiBaseURL, APP_ID, SECRET_KEY);
//        JSONObject response = SupOpenApi.getSuposObjectPropertyCurrent(apiBaseURL, clientToken.getAccessToken());
//        System.out.println("get data response : " + response);
//        // 响应结果：{"tower.upperTemperature":0.7087967357703808,"tower.lowerTemperature":0.4032736632473878}
//
//        Double upperTemperatureValue = response.getDouble("tower.upperTemperature");
//        Double lowerTemperatureValue = response.getDouble("tower.lowerTemperature");
//        // 算法（（上层温度*1.1 + 下层温度* 0.9）/ 2），计算出当前冷却系统的输出功率的一个权重参数
//        Double outputWeight = (upperTemperatureValue * 1.1 + lowerTemperatureValue * 0.9) / 2;
//        System.out.println("data : " + outputWeight);
//
//        JSONObject response2 = SupOpenApi.setSuposObjectPropertyCurrent(apiBaseURL, clientToken.getAccessToken(), outputWeight);
//        System.out.println("set data response : " + response2);
//        // 响应结果：{"result":true}
//
//        Thread.sleep(1000);
//    }
}