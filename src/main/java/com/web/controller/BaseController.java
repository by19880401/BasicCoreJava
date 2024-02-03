package com.web.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public abstract class BaseController {
    protected <T> ResponseEntity<T> getResponseEntity(String responseBody) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.add("Content-Type", "application/json; charset=utf-8");
        ResponseEntity responseEntity = new ResponseEntity(responseBody, responseHeaders, HttpStatus.OK);
        return responseEntity;
    }
}
