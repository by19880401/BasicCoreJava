package com.example.excel;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;
import java.util.Map;

/**
 * @author qianyy
 * @date 2021/6/22
 */
public class ReadExcelDemo2 {
    public static void main(String [] args){
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("C:\\Users\\qianyy\\Downloads\\计量支付测试12标ly2021年04月实际进度.xlsx"));
        List<Map<String, Object>> list = reader.readAll();
        list.stream().forEach(map->{
            map.entrySet().stream().map(e->new ImportOrExportVo());
        });
    }
}
