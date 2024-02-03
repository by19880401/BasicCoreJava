package com.web.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;

/**
 * JsonUtil, 封闭了一些常用的Json工具方法
 */
@Slf4j
public final class JsonUtil {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtil() {
    }

    static {
        objectMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }


    public static <T> T parseObject(String jsonString, Class<T> object) {
        T t = null;
        try {
            t = objectMapper.readValue(jsonString, object);
        } catch (IOException e) {
            log.error("JsonString转为自定义对象失败：{}", e.getMessage());
        }
        return t;
    }

    public static <T> T parseObject(File file, Class<T> object) {
        T t = null;
        try {
            t = objectMapper.readValue(file, object);
        } catch (IOException e) {
            log.error("从文件中读取json字符串转为自定义对象失败：{}", e.getMessage());
        }
        return t;
    }

    //将json数组字符串转为指定对象List列表或者Map集合
    public static <T> T parseJSONArray(String jsonArray, TypeReference<T> reference) {
        T t = null;
        try {
            t = objectMapper.readValue(jsonArray, reference);
        } catch (IOException e) {
            log.error("JSONArray转为List列表或者Map集合失败：{}", e.getMessage());
        }
        return t;
    }

    public static String toJSONString(Object object) {
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("Object转JSONString失败：{}", e.getMessage());
        }
        return jsonString;
    }

    public static byte[] toByteArray(Object object) {
        byte[] bytes = null;
        try {
            bytes = objectMapper.writeValueAsBytes(object);
        } catch (JsonProcessingException e) {
            log.error("Object转ByteArray失败：{}", e.getMessage());
        }
        return bytes;
    }

    public static void objectToFile(File file, Object object) {
        try {
            objectMapper.writeValue(file, object);
        } catch (JsonProcessingException e) {
            log.error("Object写入文件失败：{}", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JsonNode parseJSONObject(String jsonString) {
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(jsonString);
        } catch (IOException e) {
            log.error("JSONString转为JsonNode失败：{}", e.getMessage());
        }
        return jsonNode;
    }

    public static JsonNode parseJSONObject(Object object) {
        JsonNode jsonNode = objectMapper.valueToTree(object);
        return jsonNode;
    }

    public static String toJSONString(JsonNode jsonNode) {
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(jsonNode);
        } catch (JsonProcessingException e) {
            log.error("JsonNode转JSONString失败：{}", e.getMessage());
        }
        return jsonString;
    }

    //JsonNode是一个抽象类，不能实例化，创建JSON树形模型，得用JsonNode的子类ObjectNode，用法和JSONObject大同小异
    public static ObjectNode newJSONObject() {
        return objectMapper.createObjectNode();
    }

    //创建JSON数组对象，就像JSONArray一样用
    public static ArrayNode newJSONArray() {
        return objectMapper.createArrayNode();
    }

    public static String getString(JsonNode jsonObject, String key) {
        String s = jsonObject.get(key).asText();
        return s;
    }

    public static Integer getInteger(JsonNode jsonObject, String key) {
        Integer i = jsonObject.get(key).asInt();
        return i;
    }

    public static Boolean getBoolean(JsonNode jsonObject, String key) {
        Boolean bool = jsonObject.get(key).asBoolean();
        return bool;
    }

    public static JsonNode getJSONObject(JsonNode jsonObject, String key) {
        JsonNode json = jsonObject.get(key);
        return json;
    }

}
