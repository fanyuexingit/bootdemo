/**
 * @description:
 * @author: Andy
 * @time: 2021/02/24 16:27
 */
package com.example.bootweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * Created by fanyuexin on 2021/02/24
 */
@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Bean
    public ViewResolver getViewResolver(){
        return new ViewResolver() {
            @Override
            public View resolveViewName(String viewName, Locale locale) throws Exception {
                return null;
            }
        };
    }

    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerIntercepter())
                .addPathPatterns("/**")
                .excludePathPatterns("/", "/index", "/login", "/css/*", "/js/*", "/img/*");
    }
}
