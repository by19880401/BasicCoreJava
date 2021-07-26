package com.example.obj;

import java.util.Objects;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/26
 * @
 */
public class ObjectIsNullDemo {
    public static void main(String [] args){
        Fish f = null;
        Double d = null;
        System.out.println(Objects.isNull(f));
        System.out.println(null == f);
        System.out.println(Objects.isNull(d));
        System.out.println(null == d);
    }
}
