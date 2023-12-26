package com.objectiva.projectdemo.switchdemo;

public enum ProcessBasedOn {
    /**
     * The primary.
     */
    PRIMARY("PRIMARY"),
    /**
     * The worked.
     */
    WORKED("WORKED"),
    /**
     * The position assignment.
     */
    POSITION_ASSIGNMENT("POSITION_ASSIGNMENT");

    private String key;

    ProcessBasedOn(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
