package com.nhnacademy.springboot.repository;

import com.nhnacademy.springboot.teacher.Account;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DummyAccountRepository implements AccountRepository {
    @Override
    public List<Account> findAll() {
        return List.of(new Account("10", 1),
                new Account("20", 2));
    }
}
