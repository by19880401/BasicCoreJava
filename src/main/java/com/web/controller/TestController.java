package com.web.controller;

import com.web.entity.APIResponse;
import com.web.entity.BfsNota;
import com.web.mapper.BfsNotaMapper;
import com.web.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Willis
 * @Date 2024/2/15 20:46
 **/
@Slf4j
@RestController
public class TestController extends BaseController {

    private BfsNotaMapper bfsNotaMapper;

    @Autowired
    public void setBfsNotaMapper(BfsNotaMapper bfsNotaMapper) {
        this.bfsNotaMapper = bfsNotaMapper;
    }

    /**
     * 【不推荐】、【常用的】、【标准的】
     * 这是MyBatis中【常用的】一对多查询（ N+1 方式的查询）,即先查询主表再查询子表.这就是著名的 [n+1 问题]
     * 缺点：如果记录很多，这种查询效率是非常低效的
     *
     * @return 标准response
     */
    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public ResponseEntity<String> testFindList() {
        APIResponse res = new APIResponse();
        List<BfsNota> list = bfsNotaMapper.findList(1);
        log.info("size: {}", list.size());
        res.setSuccess(true);
        res.setData(list.size());
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }

    /**
     * 【推荐】、【高效的查询方式】
     * 完善后的查询方式，高效
     *
     * @return 标准response
     */
    @RequestMapping(value = "/findListWithHighPerformance", method = RequestMethod.GET)
    public ResponseEntity<String> testFindListWithHighPerformance() {
        APIResponse res = new APIResponse();
        List<BfsNota> list = bfsNotaMapper.findListWithHighPerformance(1);
        log.info("size: {}", list.size());
        res.setSuccess(true);
        res.setData(list.size());
        String resJsonStr = JsonUtil.toJSONString(res);
        log.info("response data :{}", resJsonStr);
        return getResponseEntity(resJsonStr);
    }


}
