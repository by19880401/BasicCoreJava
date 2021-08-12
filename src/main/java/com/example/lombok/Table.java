package com.example.lombok;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * 注解@Builder实现链式编程 假设有一个Table类，假设它有N多个属性
 *
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/8/12
 * @
 */
@Builder//构建器模式
@ToString
@Data
public class Table {
    private int id;
    private String name;
    private Date date;
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private String column5;
    private String column6;
    private String column7;
    private String column8;
    private String column9;
    private String column10;
    private String column11;
    private String column12;
    private String column13;
    private String column14;
    private String column15;
    private String column16;
    private String column17;
    private String column18;
    private String column19;
    private String column20;
    private String column21;
    private String column22;


    /**
     * 链式编程，不能写空构造方法
     */
    /*public Table() {
        super();
    }*/
}