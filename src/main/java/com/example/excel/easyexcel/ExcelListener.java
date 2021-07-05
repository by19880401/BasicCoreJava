package com.example.excel.easyexcel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author baiyang
 * @date 2021/7/5
 */
public class ExcelListener extends AnalysisEventListener<ExcelVo> {
    /**
     * 一行一行读取excel内容时处理逻辑
     * @param excelVo
     * @param analysisContext
     */
    @Override
    public void invoke(ExcelVo excelVo, AnalysisContext analysisContext) {
        System.out.println("----->" + excelVo);
    }

    /**
     * 读取表头内容时处理逻辑，此方法是可选的覆盖方法
     * @param headMap
     * @param context
     */
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context){
        System.out.println("*****-->" + headMap);
    }

    /**
     * 读取完成之后处理逻辑
     * @param analysisContext
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("读取完成！" + analysisContext.readRowHolder().getRowIndex());
    }
}
