package com.example.excel.easyexcelwithtemp;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 创建excel模版填充对应java bean
 * @author baiyang
 * @date 2021/7/5
 */
public class ExcelTempVo {
    @ExcelProperty(value = "实体单元名称", index = 0)
    private String wbsName;
    @ExcelProperty(value = "（实际）开始时间", index = 1)
    private String startStr;
    @ExcelProperty(value = "（实际）结束时间", index = 2)
    private String endStr;
    @ExcelProperty(value = "截止上月末累计完成比例（%）", index = 3)
    private String lastMonthEndPlanProgress;
    @ExcelProperty(value = "本月实际完成比例（%）", index = 4)
    private String monthActualProgress;
    @ExcelProperty(value = "实体单元编码", index = 5)
    private String websId;
    @ExcelProperty(value = "异常提示", index = 6)
    private String question;

    public String getWbsName() {
        return wbsName;
    }

    public void setWbsName(String wbsName) {
        this.wbsName = wbsName;
    }

    public String getStartStr() {
        return startStr;
    }

    public void setStartStr(String startStr) {
        this.startStr = startStr;
    }

    public String getEndStr() {
        return endStr;
    }

    public void setEndStr(String endStr) {
        this.endStr = endStr;
    }

    public String getLastMonthEndPlanProgress() {
        return lastMonthEndPlanProgress;
    }

    public void setLastMonthEndPlanProgress(String lastMonthEndPlanProgress) {
        this.lastMonthEndPlanProgress = lastMonthEndPlanProgress;
    }

    public String getMonthActualProgress() {
        return monthActualProgress;
    }

    public void setMonthActualProgress(String monthActualProgress) {
        this.monthActualProgress = monthActualProgress;
    }

    public String getWebsId() {
        return websId;
    }

    public void setWebsId(String websId) {
        this.websId = websId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
