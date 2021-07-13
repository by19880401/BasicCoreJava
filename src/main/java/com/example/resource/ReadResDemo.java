package com.example.resource;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.io.resource.ClassPathResource;

import java.io.File;
import java.io.InputStream;

/**
 * 读取资源文件，相对路径
 * @author baiyang
 * @date 2021/7/8
 */
public class ReadResDemo {
    public static void main(String [] args){
        String filePath = "template" + File.separator + "template_excel.xlsx";
        ClassPathResource resource = new ClassPathResource(filePath);
        InputStream inputStream = resource.getStream();
        String str = IoUtil.read(inputStream,"UTF-8");
        System.out.println(str);

    }
}
