package com.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参构造方法
@AllArgsConstructor// 全参构造方法
public class Geographic {
    private Integer id;
    private Province province;
    private City city;
}
