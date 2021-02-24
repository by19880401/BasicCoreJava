package com.example.enum1;

public enum CompareEnum {
    SPRING(1, "春暖花开"),
    SUMMER(2, "夏日炎炎"),
    AUTUMN(3, "秋高气爽"),
    WINTER(4, "白雪皑皑");

    private Integer key;
    private String val;

    CompareEnum(Integer key, String val) {
        this.key = key;
        this.val = val;
    }

    public Integer getKey() {
        return key;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public static CompareEnum getSeason(Integer key) {
        for (CompareEnum ele : values()) {
            if (key == ele.getKey()) {
                return ele;
            }
        }
        return null;
    }
}
