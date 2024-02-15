package com.web.entity;

import lombok.Data;
import lombok.ToString;


/**
 * 因实体名称冲突，故将此实体名称由Account-->AccountInfo
 * 仅测试，不重要，才决定改这个实体名，而保留另外一个Account
 *
 * @Author Willis
 * @Date 2024/1/23 14:45
 **/
@Data
@ToString
public class AccountInfo {
    private long id;
    private String userName;
    private String role;
    private int age;
    private String description;
    private String mobile;
    private String mail;
    private String password;
}
