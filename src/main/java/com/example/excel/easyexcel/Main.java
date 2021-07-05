package com.example.excel.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * @author baiyang
 * @date 2021/7/5
 */
public class Main {
    public static void main(String[] args) {
        String filePath = "D:\\GitHere\\src\\main\\resources\\template\\计量支付测试12标ly2021年04月实际进度.xlsx";
        EasyExcel.read(filePath, ExcelVo.class, new ExcelListener()).sheet().doRead();
    }
}
