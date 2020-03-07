package com.slash.springboot.config;

import com.slash.springboot.component.LoginHandlerInterceptor;
import com.slash.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMmcConfig {

    public class MyMvcConfig implements WebMvcConfigurer {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/").setViewName("login");
            registry.addViewController("/index.html").setViewName("login");
            registry.addViewController("/main.html").setViewName("test");
        }

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").excludePathPatterns("/index.html","/user/login","/");
        }

        @Bean
        public LocaleResolver localeResolver() {
            return new MyLocaleResolver();
        }
//        @Bean
//        public MyMvcConfig myMvcConfig() {
//            MyMvcConfig myMvcConfig = new MyMvcConfig() {
//                @Override
//                public void addViewControllers(ViewControllerRegistry registry) {
//                    registry.addViewController("/").setViewName("login");
//                    registry.addViewController("/index.html").setViewName("index");
//                }
//            };
//            return myMvcConfig;
//        }
    }


}
