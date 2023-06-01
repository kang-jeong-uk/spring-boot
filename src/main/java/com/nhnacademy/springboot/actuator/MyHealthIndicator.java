package com.nhnacademy.springboot.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyHealthIndicator implements HealthIndicator {
    private final AtomicBoolean health = new AtomicBoolean(true);

    @Override
    public Health health() {
        if(!health.get()) {
            return Health.down().build();
        }
        return Health.up().build();
    }

    public void healthFail() {
        health.set(false);
    }


    @Override
    public Health getHealth(boolean includeDetails) {
        return HealthIndicator.super.getHealth(includeDetails);
    }


}
