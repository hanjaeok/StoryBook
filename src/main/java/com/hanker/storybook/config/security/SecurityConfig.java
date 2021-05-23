package com.hanker.storybook.config.security;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception{

        http.authorizeRequests()
                .mvcMatchers("/login", "/").permitAll()
                .anyRequest().authenticated();

//        http.formLogin()
//                .loginPage("/login").permitAll();
//
//        http.logout()
//                .logoutSuccessUrl("/login");
    }

    @Override
    public void configure(WebSecurity webSecurity) throws Exception{
        webSecurity.ignoring()
                .mvcMatchers("/node_modules/**")
                .requestMatchers(PathRequest.toStaticResources().atCommonLocations());
    }


}
