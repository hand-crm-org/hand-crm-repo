package com.hand.frame.config;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;

/**
 * 跨域配置
 * @author nan.yao@hand-china.com 2019/9/11 8:44
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("GET", "POST", "HEAD", "OPTIONS", "PUT", "DELETE")
                .allowedHeaders("Content-Type",
                        "X-Requested-With",
                        "accept", "Origin",
                        "Access-Control-Request-Method",
                        "Access-Control-Request-Headers",
                        "Authorization")
                .allowCredentials(true);
    }
}