package com.objectiva.projectdemo.WFD146851;

public class InputDTO {

    /**
     * The basicType.
     */
    private CommonIdAndNameDTO basicType;
    /**
     * The categoryType.
     */
    private CommonIdAndNameDTO categoryType;
    /**
     * The inputText.
     */
    private String inputText;
    /**
     * The input.
     */
    private String input;

    /**
     * the public construction method
     */
    public InputDTO() {
        // no need to implementation
    }

    /**
     * Gets the basicType.
     *
     * @return the id
     */
    public CommonIdAndNameDTO getBasicType() {
        return this.basicType;
    }

    /**
     * Sets the basicType.
     *
     * @param basicType the basicType
     */
    public void setBasicType(CommonIdAndNameDTO basicType) {
        this.basicType = basicType;
    }

    public CommonIdAndNameDTO getCategoryType() {
        return this.categoryType;
    }

    public void setCategoryType(CommonIdAndNameDTO categoryType) {
        this.categoryType = categoryType;
    }

    public String getInputText() {
        return this.inputText;
    }

    public void setInputText(String intputText) {
        this.inputText = intputText;
    }

    public String getInput() {
        return this.input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
