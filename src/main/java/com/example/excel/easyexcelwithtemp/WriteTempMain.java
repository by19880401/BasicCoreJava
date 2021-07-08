package com.example.excel.easyexcelwithtemp;

import cn.hutool.core.io.resource.ClassPathResource;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * @author qianyy
 * @date 2021/7/8
 */
public class WriteTempMain {
    private static final int MAX_NUM = 100000;

    /**
     * 数据填充方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        // 获取模版文件资源信息、流信息, classpath:resources/template_excel.xlsx
        String templateFileName = "template_excel.xlsx";
        ClassPathResource classPathResource = new ClassPathResource("template" + File.separator + templateFileName);
        InputStream inputStream = classPathResource.getStream();

        // 临时文件目录
        ClassPathResource tempResource = new ClassPathResource("template");
        String tempPath = tempResource.getFile().getAbsolutePath();

        // 临时文件名称
        String tempFileName = System.currentTimeMillis() + "_template_excel.xlsx";

        // 临时文件路径及名称
        String tempFinalPath = tempPath + File.separator + tempFileName;;
        System.out.println("临时文件路径及名称:" + tempFinalPath);

        // 生成数据
        List<ExcelTempVo> dataList = initDataList();
        // 写入excel
        ExcelWriter excelWriter = EasyExcel.write(tempFinalPath).withTemplate(inputStream).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        // 填充集合 {.name}
        excelWriter.fill(dataList, writeSheet);
        excelWriter.finish();
    }

    private static List<ExcelTempVo> initDataList() {
        List<ExcelTempVo> resultList = Lists.newArrayList();
        for (int i = 0; i < MAX_NUM; i++) {
            ExcelTempVo excelVo = new ExcelTempVo();
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
