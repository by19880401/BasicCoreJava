package com.objectiva.Optional;

import cn.hutool.log.StaticLog;

import java.util.Optional;

public class OptionalNullDemo {
    public static void main(String[] args) {
//        testOptional(Optional.of("123"));// has value
        testOptional(null);// has no value
    }


    /**
     * what's that? amazing?
     * @param param
     */
    private static void testOptional(Optional<String> param){
        Optional<String> opt = Optional.ofNullable(param).orElse(Optional.empty());
        StaticLog.info("reset quota limits by tenantId: {}.", opt.isPresent()?opt.get():null);
    }
}
