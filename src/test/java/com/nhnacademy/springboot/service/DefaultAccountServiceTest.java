package com.nhnacademy.springboot.service;

import com.nhnacademy.springboot.teacher.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

@SpringBootTest
class DefaultAccountServiceTest {
    @Autowired
    AccountService accountService;
    @Test
    void testGetAccounts() {
        List<Account> actual = accountService.getAccounts();

        assertThat(actual).hasSize(2);
    }
}