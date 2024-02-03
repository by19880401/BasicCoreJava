package com.web.entity;

import java.util.List;

@lombok.Data
public class Data {
    private String country;
    private String access;// admin,user/guest
    private String address;
    private String signature;
    private int unreadCount;
    private String avatar;
    private String title;
    private String userId;
    private List<TagsItem> tags;// tags
    private int notifyCount;
    private Geographic geographic;
    private String phone;
    private String name;
    private String email;
    private String group;//集团，部门
}