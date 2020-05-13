package com.rabbitears.config;

import com.rabbitears.entity.Result;
import com.rabbitears.enums.ResultEnum;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Configuration
public class GlobalReturnConfig {

    @RestControllerAdvice
    static class ResultResponseAdvice implements ResponseBodyAdvice<Object> {

        @Override
        public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
            return true;
        }

        @Override
        public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
            if (o instanceof Result) {
                return o;
            }
            return Result.build(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getMessage(), o);
        }
    }
}
