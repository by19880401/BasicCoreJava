package com.example.excel.easyexcel;

import com.alibaba.excel.EasyExcel;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 读取10W条数据，轻轻松松
 *
 * @author baiyang
 * @date 2021/7/5
 */
public class ReadMain {
    public static void main(String[] args) throws FileNotFoundException {
//        String filePath = "D:\\GitHere\\src\\main\\resources\\template\\深圳XX公路2020第五施工标段2020年07月实际进度.xlsx";
        String recordId = "123";// 看看参数能不能通Listener传进去，结果是：可以传参进去
        String filePath = "C:\\Users\\qianyy\\Downloads\\test_excel.xlsx";
        File file = new File(filePath);
        /**基于poi3.16版本（poi3.17及以上，没问题），使用流，会有下述异常：java.lang.NoClassDefFoundError: org/apache/poi/poifs/filesystem/FileMagic*/
//        InputStream inputStream = new FileInputStream(file);
        EasyExcel.read(file, ExcelVo.class, new ExcelListener(recordId)).sheet().doRead();
    }
}
