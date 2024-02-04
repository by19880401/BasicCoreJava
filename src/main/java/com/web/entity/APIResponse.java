package com.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

@lombok.Data
public class APIResponse {

    private boolean success = true;// always return true if request is success

    private Integer errorCode;// 错误码

    private String errorMessage;//错误提示信息

    private String traceId;//transaction id, 唯一，优先从请求中获取，如果请求中没有，则接口自动生成一个

    private Integer showType; // error display type： 0 silent; 1 message.warn; 2 message.error; 4 notification; 9 page

    private String host; // convenient for backend Troubleshooting: host of current access server

    @JsonInclude(JsonInclude.Include.NON_NULL)// 当data不为空时，response中才返回data字段
    private Object data;
}
