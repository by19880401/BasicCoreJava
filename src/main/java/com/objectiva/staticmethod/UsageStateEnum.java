package com.objectiva.staticmethod;

public enum UsageStateEnum {
    IN_IMPLEMENTATION("InImplementation"),
    IN_PRODUCTION("InProduction");

    private final String value;

    private UsageStateEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
