package com.szewec.validate;

import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Apple a = new Apple();
        a.setName("Apple");
//        a.setPrice(123.99);// true
//        a.setPrice(1234.99);// false
        a.setPrice(null);// true
//        a.setPrice(123.9);// true
//        a.setPrice(123.0);// true
//        a.setPrice(12.999);// false
        boolean isValidApple = validate(a);
        System.out.println("------------->" + isValidApple);
    }

    /**
     * 用于校验对象的price属性精确度，3位整数，2位小数
     * @param object
     * @param <T>
     * @return
     */
    public static <T> boolean validate(T object) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<T>> cons = validator.validate(object);
        if (CollectionUtils.isEmpty(cons)) {
            return true;
        }
        return false;
    }
}
