package com.example.lambda;

import java.util.Date;

/**
 * @author baiyang
 * @date 2021/6/15
 */
public class Person {
    private String id;
    private Integer year;
    private Integer month;
    private Date planStart;
    private Date planEnd;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Date getPlanStart() {
        return planStart;
    }

    public void setPlanStart(Date planStart) {
        this.planStart = planStart;
    }

    public Date getPlanEnd() {
        return planEnd;
    }

    public void setPlanEnd(Date planEnd) {
        this.planEnd = planEnd;
    }

    @Override
    public String toString() {
        return "Person{" + "id='" + id + '\'' + ", year=" + year + ", month=" + month + ", planStart=" + planStart
            + ", planEnd=" + planEnd + '}';
    }
}
