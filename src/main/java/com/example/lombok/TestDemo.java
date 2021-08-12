package com.example.lombok;

import cn.hutool.log.StaticLog;

import java.util.Date;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/12
 * @
 */
public class TestDemo {
    public static void main(String[] args) {
        /**
         * 假设有一个Table类，假设它有N多个属性，正常情况下，我们在使用Table类的时候，会调用它的一坨getter/setter方法来取值/赋值，如下：
         */
        /*Table table = new Table();
        table.setId(1);
        table.setName("表格类");
        table.setDate(new Date());
        table.setColumn1("1");
        table.setColumn2("2");
        table.setColumn3("3");
        table.setColumn4("4");
        table.setColumn5("5");
        table.setColumn6("6");
        table.setColumn7("7");
        table.setColumn8("8");
        table.setColumn9("9");
        table.setColumn10("10");
        table.setColumn11("11");
        table.setColumn12("12");
        table.setColumn13("13");
        table.setColumn14("14");
        table.setColumn15("15");
        table.setColumn16("16");
        table.setColumn17("17");
        table.setColumn18("18");
        table.setColumn19("19");
        table.setColumn20("20");
        table.setColumn21("21");
        table.setColumn22("22");
        *//**getter类似*//*
        StaticLog.info("table-->{}",table);*/

        /**链式编程*/
        Table table = Table.builder()
                .id(2).name("表格类")
                .date(new Date())
                .column1("1")
                .column2("2")
                .column3("3")
                .column4("4")
                .column5("5")
                .column6("6")
                .column7("7")
                .column8("8")
                .column9("9")
                .column10("10")
                .column11("11")
                .column12("12")
                .column13("13")
                .column14("14")
                .column15("15")
                .column16("16")
                .column17("17")
                .column18("18")
                .column19("19")
                .column20("20")
                .column21("21")
                .column22("22")
                .build();
        StaticLog.info("table-->{}", table);
    }
}
