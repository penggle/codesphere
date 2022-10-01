package com.penglecode.xmodule.springboot.examples.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC与Thymeleaf集成的定制配置
 *
 * @author peng2.peng
 * @version 1.0.0
 */
@Configuration
public class SpringMvcThymeleafConfiguration implements WebMvcConfigurer {

    /**
     * 在不考虑内容协商(ContentNegotiationManager)的情况下，我们希望：
     * 请求【/index】和【/index.html】都能进入到相应的HandlerMethod中
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(true);
    }

}
