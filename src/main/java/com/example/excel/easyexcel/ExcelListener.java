package com.example.excel.easyexcel;

import cn.hutool.log.StaticLog;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * @author baiyang
 * @date 2021/7/5
 */
public class ExcelListener extends AnalysisEventListener<ExcelVo> {

    List<ExcelVo> list = Lists.newArrayList();
    private String id;

    public ExcelListener(String recordId) {
        this.id = recordId;
    }

    /**
     * 一行一行读取excel内容时处理逻辑
     * @param excelVo
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelVo excelVo, AnalysisContext analysisContext) {
        if (StringUtils.equals("90", excelVo.getLastMonthEndPlanProgress())) {
            // lastMonthEndPlanProgress = 90的excelVo不会被打印
            return;//return关键字在这里相当于continue，跳过当前excelVo，直接处理下一个excelVo
        }
        System.out.println("----->" + excelVo);
        list.add(excelVo);
    }

    /**
     * 读取表头内容时处理逻辑，此方法是可选的覆盖方法
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context){
        System.out.println("*****-->" + headMap);
        StaticLog.info("id={}",id);
    }

    /**
     * 读取完成之后处理逻辑
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成！" + analysisContext.readRowHolder().getRowIndex());
        StaticLog.info("data size:{}",list.size());
    }

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {
        StaticLog.warn("Exception occurs:", exception.getMessage());
        throw exception;
    }
}
