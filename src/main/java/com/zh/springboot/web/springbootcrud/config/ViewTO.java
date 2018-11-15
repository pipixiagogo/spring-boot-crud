package com.zh.springboot.web.springbootcrud.config;

import com.zh.springboot.web.springbootcrud.component.MyHandlerInterceptor;
import com.zh.springboot.web.springbootcrud.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 21:58
 * @Description:
 *
 * @Configuration
public class WebMvcConfg implements WebMvcConfigurer {
//省略
}
 @Configuration
 public class WebMvcConfg extends WebMvcConfigurationSupport {
 //省略
 }
 */

//@EnableWebMvc   不加
@Configuration
public class ViewTO implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyHandlerInterceptor()).
                addPathPatterns("/**").excludePathPatterns(
                        "/","/index.html","/asserts/css/**","/asserts/img/**","/asserts/js/**","/user/login","/webjars/**");
    }

    //registry.addWebRequestInterceptor().addPathPatterns("/**).excludePathPatterns("/","/login.html","/static/**","/user/login")




    //将MyLocaleResolver注册,有自定义的LocaleResolver就用自定义的
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }



    //    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/123").setViewName("success");
//    }
//
//    //所有的WebMvcConfigurerAdapter过时拉 用WebMvcConfigurationSupport组件都会一起起作用
//    @Bean //将组件注册在容器
//    public WebMvcConfigurationSupport webMvcConfigurerAdapter(){
//        WebMvcConfigurationSupport web =new WebMvcConfigurationSupport(){
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("index");
//                registry.addViewController("/index.html").setViewName("index");
//            }
//        };
//        return web;
//    }
}
