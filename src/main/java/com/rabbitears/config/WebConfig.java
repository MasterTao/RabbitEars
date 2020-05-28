package com.rabbitears.config;

import com.rabbitears.interceptor.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    private final List<String> list = new ArrayList<>(Arrays.asList("/user/login", "/user/register", "/user/index", "/static/**", "/v1/user/login", "/v1/user/register"));

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(list)
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/favicon.ico");

    }
}
