package com.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor//无参构造方法
@AllArgsConstructor// 全参构造方法
public class Geographic {
    @JsonIgnore
    private Integer id;
    private Province province;
    private City city;
}
