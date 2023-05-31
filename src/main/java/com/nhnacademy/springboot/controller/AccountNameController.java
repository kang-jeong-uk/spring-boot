package com.nhnacademy.springboot.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountNameController {
    @Value("${com.nhn.account.system.version}")
    // 설정값을 바인딩하기 위한 두가지 방법 : 1. @Value, 2. @ConfigurationProperties
    // Todo 1 @Value 바인딩 방법
    private String version;

}
