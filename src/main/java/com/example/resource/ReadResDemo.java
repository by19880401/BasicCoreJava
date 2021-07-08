package com.example.resource;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;

import java.io.InputStream;

/**
 * @author baiyang
 * @date 2021/7/8
 */
public class ReadResDemo {
    public static void main(String [] args){
        ClassPathResource resource = new ClassPathResource("template/template_excel.xlsx");
        InputStream inputStream = resource.getStream();


        String str = IoUtil.read(inputStream,"UTF-8");
        System.out.println(str);

    }
}
