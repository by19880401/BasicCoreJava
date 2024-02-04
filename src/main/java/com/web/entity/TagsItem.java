package com.web.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagsItem {
    @JsonIgnore //在json序列化时将java bean中的一些属性忽略掉，序列化和反序列化都受影响
    private Integer id;
    private String label;
    private String key;
}
