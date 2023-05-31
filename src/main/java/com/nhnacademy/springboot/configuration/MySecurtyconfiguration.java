package com.nhnacademy.springboot.configuration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//Spring Security 설정
//        spring-security가 클래스패스에 존재하면 health를 제외한 모든 Endpoint는 기본 자동설정기능에 의해 보호된다.
//        WebSecurityConfigurerAdapter 또는 SecurityFilterChain 빈을 설정하여 기본 자동설정을 제거하고 보안설정을 정의할 수 있다

@Configuration(proxyBeanMethods = false)
public class MySecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.securityMatcher(EndpointRequest.toAnyEndpoint());
        http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll());
        return http.build();
    }
}