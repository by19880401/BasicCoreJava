package com.web.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * {@code @Author} Willis
 *
 * @Date 2024/1/23 17:44
 **/
@Slf4j
@Controller
public class DefaultController {

    @RequestMapping(value = "/toPage", method = RequestMethod.GET)
    public String toPage(HttpServletRequest request, HttpServletResponse response) {
        String url = request.getParameter("url");
        log.info("url: {}", url);
        return url;
    }
}
