package com.supos.app.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.List;

/**
 * @Description Fastjson工具类
 * @Author chenfei
 * @Date 2021/3/11 10:45
 */
public class JsonUtils {

    private final static SerializerFeature[] defaultFeatures = {
            SerializerFeature.WriteEnumUsingToString,
            SerializerFeature.QuoteFieldNames,
            SerializerFeature.IgnoreNonFieldGetter,

            //SerializerFeature.WriteMapNullValue,
            //SerializerFeature.WriteNullListAsEmpty,
            //SerializerFeature.WriteNullStringAsEmpty,

            SerializerFeature.DisableCircularReferenceDetect,
            SerializerFeature.WriteDateUseDateFormat,
    };

    public static String toJSONString(Object object) {
        return toJSONString(object, defaultFeatures);
    }

    public static String toJSONString(Object object, SerializerFeature... features) {
        return JSON.toJSONString(object, JSON.DEFAULT_GENERATE_FEATURE, features);
    }

    public static byte[] toJSONBytes(Object object) {
        return toJSONBytes(object, defaultFeatures);
    }

    public static byte[] toJSONBytes(Object object, SerializerFeature... features) {
        return JSON.toJSONBytes(object, JSON.DEFAULT_GENERATE_FEATURE, features);
    }

    public static <T> T parseObject(String jsonString, Class<T> clazz) {
        return JSON.parseObject(jsonString, clazz);
    }

    public static <T> T parseObject(String jsonString, TypeReference<T> typeReference) {
        return JSON.parseObject(jsonString, typeReference);
    }

    public static <T> List<T> parseArray(String jsonString, Class<T> clazz) {
        return JSON.parseArray(jsonString, clazz);
    }

    public static SerializerFeature[] getDefaultfeatures() {
        return defaultFeatures;
    }
}
