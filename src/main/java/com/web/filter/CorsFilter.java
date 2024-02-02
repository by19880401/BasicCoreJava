package com.web.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决浏览跨域问题的方法二：支持跨域资源共享-CORS过滤器配置
 *
 * @Author Willis
 * @Date 2024/2/2 10:38
 **/
@Slf4j
@WebFilter(filterName = "CorsFilter")
@Configuration
public class CorsFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {
        // Nothing
        log.info("init....");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        log.info("doFilter start....");
        HttpServletResponse resp = (HttpServletResponse) response;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Methods", "POST,GET,PATCH,DELETE,PUT");
        resp.setHeader("Access-Control-Max-Age", "3600");
        resp.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        filterChain.doFilter(request, response);
        log.info("doFilter end....");
    }

    @Override
    public void destroy() {
        // Nothing
        log.info("destroy....");
    }

}
