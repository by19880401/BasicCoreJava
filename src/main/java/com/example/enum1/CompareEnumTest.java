package com.example.enum1;

public class CompareEnumTest {
    public static void main(String[] args) {
        System.out.println(CompareEnum.SPRING == CompareEnum.getSeason(1));
        System.out.println(CompareEnum.SPRING.getKey() == 1);
        System.out.println(CompareEnum.SPRING.equals(CompareEnum.getSeason(1)));


        System.out.println("***************************");
        System.out.println(getEnumVal(5));
    }

    public static String getEnumVal(Integer key) {
        CompareEnum ce = CompareEnum.getSeason(key);
        if(null == ce){
            return "";
        }
        switch (ce) {
            case SPRING:
                System.out.println("spring");
                return CompareEnum.SPRING.getVal();
            case SUMMER:
                System.out.println("summer");
                return CompareEnum.SUMMER.getVal();
            case AUTUMN:
                System.out.println("autumn");
                return CompareEnum.AUTUMN.getVal();
            case WINTER:
                System.out.println("winter");
                return CompareEnum.WINTER.getVal();
            default:
                System.out.println("no season");
                return "";
        }
    }
}
