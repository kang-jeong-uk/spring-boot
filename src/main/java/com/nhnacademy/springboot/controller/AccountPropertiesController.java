package com.nhnacademy.springboot.controller;

import com.nhnacademy.springboot.configuration.AccountProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountPropertiesController {

    private final AccountProperties accountProperties;

    @GetMapping("/system/version")
    public String getVersion() {
        return accountProperties.getVersion();
    }

}
