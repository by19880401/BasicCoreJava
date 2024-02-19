package com.web.controller;

import com.web.entity.*;
import com.web.mapper.AccountMapper;
import com.web.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class UserController extends BaseController {

    private AccountMapper accountMapper;

    @Autowired
    public void setAccountMapper(AccountMapper accountMapper) {
        this.accountMapper = accountMapper;
    }

    @RequestMapping(value = {"/currentUser", "/secret/currentUser"}, method = RequestMethod.GET)
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
            tag.setTagId(String.valueOf(i));
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

    /**
     * 集成mybatis-plus，实现从db中一对多查询数据
     * 【不推荐mybatis-plus】、【不友好】、【很费劲】、【逻辑非常乱】
     * 大神们 推荐 【Spring Data JPA】
     *
     * @return 正常的response
     */
    @RequestMapping(value = {"/currentUserFromDb"}, method = RequestMethod.GET)
    public ResponseEntity<String> findUserFromDatabase() {
        log.info("receive a request from API :: /currentUserFromDb");
        APIResponse res = new APIResponse();
        res.setSuccess(true);
        List<Account> accountList = accountMapper.findAccounts();
        if (CollectionUtils.isEmpty(accountList)) {
            String resJsonStr = JsonUtil.toJSONString(res);
            log.info("No account found.");
            return getResponseEntity(resJsonStr);
        }
        Account account = accountList.get(0);
        res.setData(account);
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }

    /**
     * @param requestStr a request as JSON string
     * @return a response with special code & message
     * @ RequestBody注解： 1.@RequestBody注解一般与post方法使用
     * 2.一个请求中只能存在一个@RequestBody注解
     * 3.@RequestBody 用于接收前端传递给后端的json字符串数据(处理json格式的数据）
     * 两种格式：(@RequestBody Map map)和(@RequestBody Object object)
     * 此处是：(@RequestBody Object object)，这里Object是String，完整的json请求，需要使用JsonUtil类进行转化
     * 即：通过json字符串中的key来匹配对应实体类的属性，如果匹配一致且json中的该key对应的值符合实体类的对应属性的类型要求时,会调用实体类的setter方法将值注入到该属性
     */
    @RequestMapping(value = "/registerWithJsonStr", method = RequestMethod.POST)
    public ResponseEntity<String> registerUserWithJsonStr(@RequestBody String requestStr) {
        APIResponse res = new APIResponse();
        log.info("req: {}", requestStr);
        res.setSuccess(true);
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }

    /**
     * @param accountInfo 特别注意，这里的accountInfo一定要与前端参数名称相对应，详见前端代码sendReqToBackend08(...)
     * @return a response with error code & message
     */
    @RequestMapping(value = "/registerWithObject", method = RequestMethod.POST)
    public ResponseEntity<String> registerUserWithObj(@RequestBody AccountInfo accountInfo) {
        APIResponse res = new APIResponse();
        log.info("req: {}", accountInfo.toString());
        res.setSuccess(true);
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }

    /**
     * @param userId，必传参数，前端你们传入的参数名称为：uId
     * @param userName，必传参数，前端你们传入的参数名称为：userName
     * @param address，必传参数，前端你们传入的参数名称为：address
     * @param age,                                不添加@RequestParam，该参数在前端可传，也可不传
     * @return a response with the code & message
     * @ RequestParam 注解:
     * 1.@RequestParam一般与get请求一起使用
     * 2.一个请求（一个方法中）可以有多个@RequestParam
     * 3.@RequestParam 用来接收普通参数
     * 4.添加@RequestParam时，对应的参数为必传；反之，对应的参数为非必传
     * 5.@RequestParam中required值默认为true，可以设置为false非必传
     * 6.通过@RequestParam("userId")或者@RequestParam(value = "userId")指定参数名, 如果不指定（比如：@RequestParam String address或者int age），也能从前端传入，默认的变量名就是参数名（比如：address和age），亲测
     * 7.通过参数defaultValue = "0"可以指定参数默认值。注意：当为require设置为false时才可以使用defaultValue，亲测，前端没有传isMxEngineer，required = false，如下，它使用了默认值false，但当前端传入isMxEngineer的值时，会接受到前端传入的真实的值
     */
    @RequestMapping(value = "/registerWithRequestParam", method = RequestMethod.GET)
    public ResponseEntity<String> registerUserWithRequestParam(@RequestParam("uId") int userId, @RequestParam("userName") String userName, @RequestParam String address, int age, @RequestParam(required = false, defaultValue = "false") boolean isMxEngineer) {
        APIResponse res = new APIResponse();
        // 结果：req: [userId: 1001, userName: Yang, address:Xi Fen 3rd Road #251, age:18, isMxEngineer: false]
        log.info("req: [userId: {}, userName: {}, address:{}, age:{}, isMxEngineer: {}]", userId, userName, address, age, isMxEngineer);
        res.setSuccess(true);
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }

    /**
     * @param userAddress, 方法参数名称和需要绑定的url中变量名称不一致时，在@PathVariable("address")指定名称为address
     * @param age          方法参数名称和需要绑定的url中变量名称一致时,不用在@PathVariable中指定名称
     * @return 1.@PathVariable 映射 URL 绑定的占位符
     * 2.通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中:URL 中的 {xxx}占位符可以通过@PathVariable(“xxx”) 绑定到操作方法的入参中
     * 3.一般与@RequestMapping(method = RequestMethod.GET)一起使用
     */
    @RequestMapping(value = "/registerWithPathVariable/{address}/{age}", method = RequestMethod.GET)
    public ResponseEntity<String> registerUserWithPathVariable(@PathVariable("address") String userAddress, @PathVariable int age) {
        APIResponse res = new APIResponse();
        log.info("req: {},{}", userAddress, age);
        res.setSuccess(true);
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }
}
