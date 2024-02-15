package com.beijingwujian.web;

import com.web.entity.BfsNota;
import com.web.mapper.BfsNotaMapper;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author Willis
 * @Date 2024/2/15 19:44
 **/
@Slf4j
@NoArgsConstructor
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class MybatisPlusTest {

    private BfsNotaMapper bfsNotaMapper;

    @Autowired
    public void setBfsNotaMapper(BfsNotaMapper bfsNotaMapper) {
        this.bfsNotaMapper = bfsNotaMapper;
    }

    @BeforeEach
    public void setUp(){
        log.info("set up.....");
    }

    @AfterEach
    public void stop(){
        log.info("stop....");
    }

    @Test
    public void testFindList(){
        List<BfsNota> list = bfsNotaMapper.findList(1);
        log.info("size:{}", list.size());
    }

}
