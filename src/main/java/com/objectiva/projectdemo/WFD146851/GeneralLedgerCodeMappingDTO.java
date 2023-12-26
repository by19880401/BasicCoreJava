package com.objectiva.projectdemo.WFD146851;
/**
 * The Class GeneralLedgerCodeMappingDTO.
 */
public class GeneralLedgerCodeMappingDTO {

    /** The id. */
    private Long id;

    /** The input type. */
    private CommonIdAndNameDTO inputType;

    /** The input type value. */
    private CommonIdAndNameDTO inputTypeValue;

    /** The input. */
    private InputDTO input;

    /** The output. */
    private CommonOutputDTO output1;

    /** The output2. */
    private CommonOutputDTO output2;

    /** The output3. */
    private CommonOutputDTO output3;

    /** The sortOrder. */
    private Long sortOrder;

    /** The is updated. */
    private boolean isUpdated;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the input type.
     *
     * @return the inputType
     */
    public CommonIdAndNameDTO getInputType() {
        return inputType;
    }

    /**
     * Sets the input type.
     *
     * @param inputType
     *            the inputType to set
     */
    public void setInputType(CommonIdAndNameDTO inputType) {
        this.inputType = inputType;
    }

    /**
     * Gets the input type value.
     *
     * @return the inputTypeValue
     */
    public CommonIdAndNameDTO getInputTypeValue() {
        return inputTypeValue;
    }

    /**
     * Sets the input type value.
     *
     * @param inputTypeValue
     *            the inputTypeValue to set
     */
    public void setInputTypeValue(CommonIdAndNameDTO inputTypeValue) {
        this.inputTypeValue = inputTypeValue;
    }

    /**
     * Gets the input.
     *
     * @return the input
     */
    public InputDTO getInput() {
        return input;
    }

    /**
     * Sets the input.
     *
     * @param input
     *            the input to set
     */
    public void setInput(InputDTO input) {
        this.input = input;
    }

    /**
     * Gets the output.
     *
     * @return the output
     */
    public CommonOutputDTO getOutput1() {
        return output1;
    }

    /**
     * Sets the output.
     *
     * @param output1
     *            the output to set
     */
    public void setOutput1(CommonOutputDTO output1) {
        this.output1 = output1;
    }

    /**
     * Gets the output2.
     *
     * @return the output2
     */
    public CommonOutputDTO getOutput2() {
        return output2;
    }

    /**
     * Sets the output2
     *
     * @param output2 the output2 to set
     */
    public void setOutput2(CommonOutputDTO output2) {
        this.output2 = output2;
    }

    /**
     * Gets the output3.
     *
     * @return  the output3
     */
    public CommonOutputDTO getOutput3() {
        return output3;
    }

    /**
     * Sets the output3
     *
     * @param output3  the output3 to set
     */
    public void setOutput3(CommonOutputDTO output3) {
        this.output3 = output3;
    }

    /**
     * Gets the sortOrder.
     *
     * @return the sortOrder
     */
    public Long getSortOrder() { return sortOrder; } /**
     * Sets the sortOrder.
     *
     * @param sortOrder
     * the sortOrder to set
     */
    public void setSortOrder(Long sortOrder) { this.sortOrder = sortOrder; }

    /**
     * Gets the is updated.
     *
     * @return  the is updated
     */
    public boolean getUpdated() {
        return isUpdated;
    }
    /**
     * Sets the isUpdated
     *
     * @param updated  the updated to set
     */
    public void setUpdated(boolean updated) {
        isUpdated = updated;
    }
}

