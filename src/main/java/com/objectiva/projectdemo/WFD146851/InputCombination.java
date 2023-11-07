package com.objectiva.projectdemo.WFD146851;

public class InputCombination {
    /**
     * The input id.
     */
    private Long inputId;

    /**
     * The input type value id.
     */
    private Long inputTypeValueId;

    /**
     * The input type id.
     */
    private Long inputTypeId;

    /**
     * Instantiates a new input combination.
     *
     * @param inputId          the input id
     * @param inputTypeValueId the input type value id
     * @param inputTypedId     the input typed id
     */
    InputCombination(Long inputId, Long inputTypeValueId, Long inputTypedId) {
        this.inputId = inputId;
        this.inputTypeId = inputTypedId;
        this.inputTypeValueId = inputTypeValueId;
    }

    /**
     * Gets the input id.
     *
     * @return the input id
     */
    Long getInputId() {
        return this.inputId;
    }

    /**
     * Gets the input type value id.
     *
     * @return the input type value id
     */
    Long getInputTypeValueId() {
        return this.inputTypeValueId;
    }

    /**
     * Gets the input type id.
     *
     * @return the input type id
     */
    Long getInputTypeId() {
        return this.inputTypeId;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((inputId == null) ? 0 : inputId.hashCode());
        result = prime * result + ((inputTypeId == null) ? 0 : inputTypeId.hashCode());
        result = prime * result + ((inputTypeValueId == null) ? 0 : inputTypeValueId.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        InputCombination other = (InputCombination) obj;

        if (inputId == null) {
            if (other.inputId != null)
                return false;
        } else if (!inputId.equals(other.inputId)) {
            return false;
        }
        if (inputTypeId == null) {
            if (other.inputTypeId != null)
                return false;
        } else if (!inputTypeId.equals(other.inputTypeId)) {
            return false;
        }
        if (inputTypeValueId == null) {
            if (other.inputTypeValueId != null)
                return false;
        } else if (!inputTypeValueId.equals(other.inputTypeValueId)) {
            return false;
        }
        return true;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "InputCombination [inputId=" + inputId + ", inputTypeValueId=" + inputTypeValueId + ", inputTypeId=" + inputTypeId + "]";
    }
}
