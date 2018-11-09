package com.gwg.demo.web.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.MultipartConfigElement;

/**
 * 上传文件大小配置
 */
@Configuration
public class UploadConfig {



    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //文件最大
        factory.setMaxFileSize("20MB"); //KB,MB
        /// 设置总上传数据总大小
        factory.setMaxRequestSize("20MB");
        return factory.createMultipartConfig();
    }
}
