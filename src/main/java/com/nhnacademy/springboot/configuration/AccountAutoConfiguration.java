package com.nhnacademy.springboot.configuration;


import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(AccountProperties.class)
//Todo 2-1 AccountProperties.class를 등록한다.
public class AccountAutoConfiguration {
}
