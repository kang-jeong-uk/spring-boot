package com.nhnacademy.springboot.controller;


import com.nhnacademy.springboot.actuator.MyHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ManagementController {

    private final MyHealthIndicator myHealthIndicator;

    @PostMapping("/management/fail")
    public String healthFail() {
        myHealthIndicator.healthFail();
        return "fail";
    }
}
