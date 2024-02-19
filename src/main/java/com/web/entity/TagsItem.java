package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("tags_item")
public class TagsItem implements Serializable {
    @JsonIgnore //在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    @TableField("label")//当名称一致时，此注解可写亦可不写
    private String label;
    @JsonProperty(value = "key")
    @TableField("f_tag_id")
    private String tagId;//外键 TODO don't know why there is no value
}
