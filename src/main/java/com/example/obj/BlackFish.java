package com.example.obj;

import lombok.Data;
import lombok.ToString;

/**
 * callSuper=true打印父类属性
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/28
 * @
 */
@ToString(callSuper = true)//默认只ToString只打印当前类的属性，如果要打印其父类的属性，则要加callSuper=true
@Data
public class BlackFish extends Fish{
    private String color;
}
