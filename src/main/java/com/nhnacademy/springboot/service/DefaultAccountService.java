package com.nhnacademy.springboot.service;

import com.nhnacademy.springboot.repository.AccountRepository;
import com.nhnacademy.springboot.teacher.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;

    public DefaultAccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }
}
