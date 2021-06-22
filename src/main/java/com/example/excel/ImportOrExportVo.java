package com.example.excel;

/**
 * @author qianyy
 * @date 2021/6/22
 */
public class ImportOrExportVo {
    private String wbsName;
    private String startStr;
    private String endStr;
    private String lastMonthEndPlanProgress;
    private String monthActualProgress;
    private String websId;

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

    @Override
    public String toString() {
        return "ImportOrExportVo{" + "wbsName='" + wbsName + '\'' + ", startStr='" + startStr + '\'' + ", endStr='"
            + endStr + '\'' + ", lastMonthEndPlanProgress='" + lastMonthEndPlanProgress + '\''
            + ", monthActualProgress='" + monthActualProgress + '\'' + ", websId='" + websId + '\'' + ", question='"
            + question + '\'' + '}';
    }
}
