package com.ImageMatcherProject.Image_Matcher.Configuration;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FileUploadConfig {

    @Bean
    public MultipartConfigFactory multipartConfigFactory() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        return factory;
    }
}


