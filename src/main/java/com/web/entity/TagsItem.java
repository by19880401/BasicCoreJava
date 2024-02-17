package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagsItem implements Serializable {
    @JsonIgnore //在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响
    @TableId(type = IdType.AUTO)
    private long id;
    private String label;
    @TableField("ftag_id")
    @JsonProperty(value = "key")
    private String tagId;//外建
}
