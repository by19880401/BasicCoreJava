package com.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "basic_core_java_account")
public class Account implements Serializable {
    @TableId(type = IdType.AUTO)
    private long id;
    private String country;
    private String access;// admin,user,guest
    private String address;
    private String signature;
    @TableField(value = "unread_count")
    private int unreadCount;
    private String avatar;
    private String title;
    @TableField("user_id")
    private String userId;// Primary key
    @JsonProperty(value = "tags")
    @TableField("tag_id")
    private List<TagsItem> tags;// tags
    @TableField("notify_count")
    private int notifyCount;
    @JsonProperty(value = "geographic")
    private Geographic geographic;
    private String phone;
    private String name;
    private String email;
    @JsonProperty(value = "group")
    private String department;//集团，部门
}