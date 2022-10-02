package com.penglecode.xmodule.security.examples.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 简单Spring-Security示例配置
 *
 * @author peng2.peng
 * @version 1.0.0
 */
@Configuration
public class SimpleSecurityExampleConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) {
        //配置静态文件不需要认证
        web.ignoring().antMatchers("/static/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            //指定当前SecurityFilterChain实例匹配哪些请求
            .requestMatchers().anyRequest()
        .and()
            .authorizeRequests()
                .mvcMatchers("/error").permitAll() //排除SpringBoot的error页面
                .mvcMatchers("/anon/**").permitAll()
                .mvcMatchers("/user/**").hasRole("user")
                .mvcMatchers("/admin/**").hasRole("admin")
                //其余请求都需要登录认证
                .anyRequest().authenticated()
        .and()
            .formLogin()
                .loginPage("/login").permitAll()
                .usernameParameter("username")
                .passwordParameter("password")
                //.loginProcessingUrl("/login/submit") //自己处理登录用户名/密码校验逻辑的.一般没必要,Spring-Security自带处理POST[/login]的逻辑(见UsernamePasswordAuthenticationFilter)
                //.failureForwardUrl("/login?error")
                .defaultSuccessUrl("/index")
        .and()
            .logout()
                .logoutUrl("/logout").permitAll()
                .logoutSuccessUrl("/login")
                .clearAuthentication(true)
                .invalidateHttpSession(true)
        .and()
            .exceptionHandling()
                .accessDeniedPage("/403")
        .and()
            .csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user").password("{noop}123456").roles("user")
                .and()
                .withUser("admin").password("{noop}123456").roles("admin");
    }
}
