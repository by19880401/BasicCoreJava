package com.example.json;

import cn.hutool.log.StaticLog;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * writeValueAsString(list)中的list可换成其他对象，如javabean，数组，集合等
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/31
 * @
 */
public class JacksonDemo {
    public static void main(String[] args) throws IOException {
        List<User> uList = initList();
        ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        String jsonStr = mapper.writeValueAsString(uList);//将List转为json
        StaticLog.info("List-->json: {}", jsonStr);

        List<User> userList = mapper.readValue(jsonStr, new TypeReference<List<User>>() {});// 将json转为List
        StaticLog.info("Json-->List:{}", userList);

    }

    /**
     * 初始化一个对象List
     *
     * @return
     */
    private static List<User> initList() {
        return Arrays.asList(
                new User(1, "Willis", "pw01"),
                new User(2, "Cola", "pw02"),
                new User(3, "Harry Potter", "pw03"));
    }
}
