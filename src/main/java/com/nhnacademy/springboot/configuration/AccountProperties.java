package com.nhnacademy.springboot.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "com.nhn.account.system")
@Getter
@Setter
//Todo 2 @ConfigurationProperties 바인딩 방법
public class AccountProperties {
    private String version;
}
