package com.szewec.validate;

import javax.validation.constraints.Digits;

public class Apple {
    private String name;
    @Digits(integer = 3, fraction = 2)
    private Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
