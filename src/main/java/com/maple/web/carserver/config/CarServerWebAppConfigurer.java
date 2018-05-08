package com.maple.web.carserver.config;

import com.maple.web.carserver.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
public class CarServerWebAppConfigurer extends WebMvcConfigurationSupport {

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
//                .excludePathPatterns("/account/doLogin")
//                .excludePathPatterns("/account/doRegister")
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/account/login")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/account/register");
        super.addInterceptors(registry);

    }
}
