package com.example.excel.easyexcelwithtemp;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.google.common.collect.Lists;
import org.apache.commons.lang.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

/**
 * 该类功能同WriteTempMain，仅把读取路径简易化了一些
 * 
 * @author baiyang
 * @date 2021/7/8
 */
public class WriteTempWithSimplePathMain {
    private static final int MAX_NUM = 100000;

    /**
     * 数据填充方法
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            // 获取模版文件资源信息、流信息
            String readPath = "C:\\Users\\qianyy\\Downloads\\template_excel.xlsx";
            InputStream inputStream = new FileInputStream(new File(readPath));

            // 根据上述模板，进行写操作时，输出的文件名称
            String writePath = "C:\\Users\\qianyy\\Downloads\\" + System.currentTimeMillis() + "_template_excel.xlsx";
            System.out.println("输出的文件路径及名称:" + writePath);

            // 生成数据
            List<ExcelTempVo> dataList = initDataList();
            // 写入excel
            ExcelWriter excelWriter = EasyExcel.write(writePath).withTemplate(inputStream).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            // 填充集合 {.name}
            excelWriter.fill(dataList, writeSheet);
            excelWriter.finish();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
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
