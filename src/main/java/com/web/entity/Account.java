package com.web.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@lombok.Data
public class Account {
    private String country;
    private String access;// admin,user,guest
    private String address;
    private String signature;
    private int unreadCount;
    private String avatar;
    private String title;
    private String userId;// Primary key
    @JsonProperty(value = "tags")
    private List<TagsItem> tags;// tags
    private int notifyCount;
    @JsonProperty(value = "geographic")
    private Geographic geographic;
    private String phone;
    private String name;
    private String email;
    @JsonProperty(value = "group")
    private String department;//集团，部门
}