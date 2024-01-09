package com.beijingwujian.log;

public enum FileType {
    MARKDOWN(".md"), TEXT(".txt");

    private String suffix;

    FileType(String suffix) {
        this.suffix = suffix;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }
}
