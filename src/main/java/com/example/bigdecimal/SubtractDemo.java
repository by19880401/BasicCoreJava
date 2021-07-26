package com.example.bigdecimal;

import cn.hutool.log.StaticLog;

import java.math.BigDecimal;

/**
 * BigDecimal相减
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/26
 * @
 */
public class SubtractDemo {
    public static void main(String[] args) {
        String excelVal = "2.26";
        Double dbVal = 1.51D;
        Double originVal = 2.15D;
        BigDecimal db = new BigDecimal(excelVal).subtract(new BigDecimal(String.valueOf(dbVal))).add(new BigDecimal(String.valueOf(originVal)));
        StaticLog.info("Result: {}", db.doubleValue());
    }

}
