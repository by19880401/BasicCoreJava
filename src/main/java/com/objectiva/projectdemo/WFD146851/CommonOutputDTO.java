package com.objectiva.projectdemo.WFD146851;

public class CommonOutputDTO {
    private CommonIdAndNameDTO mappingType;
    private CommonIdAndNameDTO sourceType;
    private String outputText;
    private String output;

    public CommonOutputDTO() {
    }

    public CommonIdAndNameDTO getMappingType() {
        return this.mappingType;
    }

    public void setMappingType(CommonIdAndNameDTO mappingType) {
        this.mappingType = mappingType;
    }

    public CommonIdAndNameDTO getSourceType() {
        return this.sourceType;
    }

    public void setSourceType(CommonIdAndNameDTO sourceType) {
        this.sourceType = sourceType;
    }

    public String getOutputText() {
        return this.outputText;
    }

    public void setOutputText(String outputText) {
        this.outputText = outputText;
    }

    public String getOutput() {
        return this.output;
    }

    public void setOutput(String output) {
        this.output = output;
    }
}
