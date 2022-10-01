package com.penglecode.xmodule.springboot.examples.boot;

import com.penglecode.codeforce.mybatistiny.EnableMybatisTiny;
import com.penglecode.xmodule.BasePackage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 示例项目SpringBoot启动类
 *
 * @author pengpeng
 * @version 1.0
 */
@EnableMybatisTiny
@AutoConfigurationPackage(basePackageClasses=BasePackage.class)
@SpringBootApplication(scanBasePackageClasses=BasePackage.class)
public class SpringBootExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
    }

}