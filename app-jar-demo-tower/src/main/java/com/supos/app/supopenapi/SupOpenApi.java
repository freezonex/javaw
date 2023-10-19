package com.supos.app.supopenapi;

import com.alibaba.fastjson.JSONObject;
import com.supos.app.dto.PropValues;
import com.supos.app.dto.SuposObjectPropertyCurrentBody;
import com.supos.app.dto.SuposObjectPropertySetValuesBody;
import com.supos.app.utils.HttpUtils;
import com.supos.app.utils.JsonUtils;
import org.springframework.http.HttpHeaders;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description  supOS（V2.7）-OpenAPI 调用案例
 * @Author chenfei
 * @Date 2021/4/14 13:44
 */
public class SupOpenApi {

    /**
     * 获取supOS对象属性的实时值
     *
     * @param suposAddress
     * @param accessToken
     * @return
     */
    public static JSONObject getSuposObjectPropertyCurrent(String suposAddress, String accessToken) {
        String path = suposAddress + "/openapi/objects/v1/properties/current";

        Map<String, String> headerParams = new HashMap<>();
        headerParams.put(HttpHeaders.CONTENT_TYPE, "application/json");
        headerParams.put(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        SuposObjectPropertyCurrentBody body = new SuposObjectPropertyCurrentBody();
        String[] strings = new String[]{"tower.upperTemperature", "tower.lowerTemperature"};
        body.setParams(strings);

        String result = HttpUtils.doPost(path, body, headerParams);
        return JSONObject.parseObject(result);
    }

    /**
     * 给supOS的对象属性设置值
     *
     * @param suposAddress
     * @param accessToken
     * @param value
     * @return
     */
    public static JSONObject setSuposObjectPropertyCurrent(String suposAddress, String accessToken, Double value) {
        String path = suposAddress + "/openapi/objects/v1/properties/pump/services/setPropertyValues";

        Map<String, String> headerParams = new HashMap<>();
        headerParams.put(HttpHeaders.CONTENT_TYPE, "application/json");
        headerParams.put(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken);

        SuposObjectPropertySetValuesBody body = new SuposObjectPropertySetValuesBody();
        PropValues propValues = new PropValues();
        propValues.setOuterWeigh(value);
        body.setPropValues(JsonUtils.toJSONString(propValues));
        // 或 String body = "{\"propValues\":\"{\\\"outerWeigh\\\": "+value+"}\"}";

        String result = HttpUtils.doPost(path, body, headerParams);
        return JSONObject.parseObject(result);
    }

}
