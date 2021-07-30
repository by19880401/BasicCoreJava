package com.example.exception;

import cn.hutool.log.StaticLog;

import java.math.BigDecimal;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/30
 * @
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        String resultStatus = handleException();
        StaticLog.info("resultStatus:{}", resultStatus);
        /**
         * case1: intVal=0,无异常的情况
         * 14:12:40.271 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
         * 14:12:40.274 [main] INFO com.example.exception.ExceptionDemo - 收尾操作
         * 14:12:40.274 [main] INFO com.example.exception.ExceptionDemo - resultStatus:processed
         *
         * case2:intVal=null，有异常的情况
         *14:14:42.997 [main] DEBUG cn.hutool.log.LogFactory - Use [Slf4j] Logger As Default.
         * 14:14:43.002 [main] WARN com.example.exception.ExceptionDemo - 异常了：java.lang.NullPointerException
         * 14:14:43.002 [main] INFO com.example.exception.ExceptionDemo - 收尾操作
         * 14:14:43.002 [main] INFO com.example.exception.ExceptionDemo - resultStatus:error
         */
    }

    private static String handleException() {
        Integer intVal = null;
        try {
            new BigDecimal(intVal);
        } catch (Exception e) {
            StaticLog.warn("异常了：{}", e);
            return "error";//出现异常的情况，返回：error
        } finally {
            StaticLog.info("收尾操作");
        }
        return "processed";//其它情况都返回processed
    }
}
