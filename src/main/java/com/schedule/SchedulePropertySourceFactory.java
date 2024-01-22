package com.schedule;

import org.springframework.boot.env.YamlPropertySourceLoader;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

/**
 * {@code @Author} Willis
 * @Date 2024/1/22 11:20
 **/
public class SchedulePropertySourceFactory implements PropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource encodedResource) throws IOException {
        return new YamlPropertySourceLoader().load(name, encodedResource.getResource()).get(0);
    }
}
