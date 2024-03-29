package com.web.controller;

import com.web.entity.AccountInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * pringBoot项目中resources/templates下的静态资源是不能直接访问的，原因是没有开放访问权限的，
 * 因为templates下可能存放有后台管理的页面资源，当templates对外开放就会产生安全隐患，
 * 所以templates下的资源需要通过ViewResolver(视图解析器)去解析访问
 */
//@CrossOrigin //解决浏览跨域问题的方法一：给每个controller加@CrossOrigin
@Slf4j
@Controller // 不能使用@RestController，否则会以Json格式响应到页面，不会进行视图解析
public class WelcomeController {
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String index(Model model) {
        log.info("Receive a request now.");
        // 假设我们要返回从database中查询出来的用户的信息
        AccountInfo accountInfo = new AccountInfo();
        accountInfo.setId(1000);
        accountInfo.setUserName("Willis Bai");
        accountInfo.setRole("Admin");
        accountInfo.setAge(35);
        accountInfo.setDescription("这是一个测试页面！！");
        // 把用户信息保存在Model对象中
        model.addAttribute("user", accountInfo);
        return "/welcome";
    }
}
