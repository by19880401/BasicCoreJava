package com.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
public class APIResponse {

    private boolean success = true;// always return true if request is success

    @JsonInclude(JsonInclude.Include.NON_NULL)// 当data不为空时，response中才返回data字段
    private Object data;
}
