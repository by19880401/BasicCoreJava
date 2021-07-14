package com.example.excel.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * 写10W条数据，轻轻松松
 * @author baiyang
 * @date 2021/7/5
 */
public class WriteMain {
    private static final int MAX_NUM = 100;

    public static void main(String[] args) {
        String filePath = "C:\\Users\\qianyy\\Downloads\\test_excel.xlsx";
        List<ExcelVo> dataList = initDataList();
        EasyExcel.write(filePath, ExcelVo.class).sheet("Excel Sheet Demo").doWrite(dataList);
    }

    private static List<ExcelVo> initDataList() {
        List<ExcelVo> resultList = Lists.newArrayList();
        for (int i = 0; i < MAX_NUM; i++) {
            ExcelVo excelVo = new ExcelVo();
            excelVo.setWbsName(i + ">现浇混凝土垫层");
            excelVo.setStartStr("2020-03-11");
            excelVo.setEndStr("2020-04-30");
            excelVo.setLastMonthEndPlanProgress(String.valueOf(i));
            excelVo.setMonthActualProgress(i + "%");
            excelVo.setWebsId(StringUtils.replace(UUID.randomUUID().toString(), "-", ""));
            resultList.add(excelVo);
        }
        return resultList;
    }
}
