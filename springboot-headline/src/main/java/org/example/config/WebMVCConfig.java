package org.example.config;

import org.example.interceptors.LoginProtectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: xuxiaolei
 * @Description: TODO:
 * @CreatTime: 2025/07/15 11:07
 **/
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginProtectInterceptor  loginProtectInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginProtectInterceptor).addPathPatterns("/headline/**");
    }
}
