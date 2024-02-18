package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor//无参构造方法
@AllArgsConstructor// 全参构造方法
@TableName("geographic")
public class Geographic implements Serializable {
    @JsonIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Province province;
    private City city;
}
