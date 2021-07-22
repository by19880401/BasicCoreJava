package com.example.obj;

import lombok.Data;
import lombok.ToString;

/**
 * @author bai.yang email:willis.bai@outlook.com
 * @date 2021/7/22
 * @
 */
@Data
@ToString
public class Fish {
    /**
     * 使用int修饰，默认值是0；使用Integer修饰，默认值是null，推荐用Integer修饰属性
     */
    private Integer id;
    private String name;
    private String address;
}
