package com.example.excel.easyexcel;

import com.alibaba.excel.EasyExcel;

/**
 * 读取10W条数据，轻轻松松
 * @author baiyang
 * @date 2021/7/5
 */
public class ReadMain {
    public static void main(String[] args) {
//        String filePath = "D:\\GitHere\\src\\main\\resources\\template\\深圳XX公路2020第五施工标段2020年07月实际进度.xlsx";
        String filePath = "C:\\Users\\qianyy\\Downloads\\test_excel.xlsx";
        EasyExcel.read(filePath, ExcelVo.class, new ExcelListener()).sheet().doRead();
    }
}
