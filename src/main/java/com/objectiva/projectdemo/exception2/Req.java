package com.objectiva.projectdemo.exception2;

public class Req {
    private String processBasedOnType;
    private String customField;
    private String positionCustomField;

    public Req(String processBasedOnType, String customField, String positionCustomField) {
        this.processBasedOnType = processBasedOnType;
        this.customField = customField;
        this.positionCustomField = positionCustomField;
    }

    public String getProcessBasedOnType() {
        return processBasedOnType;
    }

    public void setProcessBasedOnType(String processBasedOnType) {
        this.processBasedOnType = processBasedOnType;
    }

    public String getCustomField() {
        return customField;
    }

    public void setCustomField(String customField) {
        this.customField = customField;
    }

    public String getPositionCustomField() {
        return positionCustomField;
    }

    public void setPositionCustomField(String positionCustomField) {
        this.positionCustomField = positionCustomField;
    }
}
