package com.nhnacademy.springboot.service;

import com.nhnacademy.springboot.repository.AccountRepository;
import com.nhnacademy.springboot.teacher.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@SpringBootTest
class AccountServiceTest {
    @Autowired
    AccountRepository accountRepository;
    @Test
    void testGetAccounts() {
        Account account = new Account(1L, "100", 100);
        accountRepository.save(account);
        Optional<Account> actual = accountRepository.findById(1L);

        assertThat(actual).isPresent();
        assertThat(actual.get()).isEqualTo(account);
    }

}