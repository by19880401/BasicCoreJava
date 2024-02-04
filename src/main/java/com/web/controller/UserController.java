package com.web.controller;

import com.web.entity.*;
import com.web.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class UserController extends BaseController {
    @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseEntity<String> findUser() {
        log.info("receive a request from API :: /currentUser");
        APIResponse res = new APIResponse();
        Account currentUser = new Account();
        currentUser.setName("Serati Ma");
        currentUser.setAvatar("https://gw.alipayobjects.com/zos/antfincdn/XAosXuNZyF/BiazfanxmamNRoxxVxka.png");
        currentUser.setUserId("00000001");
        currentUser.setEmail("antdesign@alipay.com");
        currentUser.setSignature("海纳百川，有容乃大");
        currentUser.setTitle("交互专家");
        currentUser.setDepartment("蚂蚁金服－某某某事业群－某某平台部－某某技术部－UED");
        List<TagsItem> tags = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            TagsItem tag = new TagsItem();
            tag.setKey(String.valueOf(i));
            tag.setLabel("很有想法的");
            tags.add(tag);
        }
        currentUser.setTags(tags);
        currentUser.setNotifyCount(12);
        currentUser.setUnreadCount(2);
        currentUser.setCountry("China");
        currentUser.setAccess("admin");
        Province province = new Province();
        province.setKey("330000");
        province.setLabel("浙江省");
        City city = new City();
        city.setKey("330100");
        city.setLabel("杭州市");
        Geographic geographic = new Geographic();
        geographic.setProvince(province);
        geographic.setCity(city);
        currentUser.setGeographic(geographic);
        currentUser.setAddress("西湖区工专路 77 号");
        currentUser.setPhone("0752-268888888");
        res.setSuccess(true);
        res.setData(currentUser);
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);

    }
}
