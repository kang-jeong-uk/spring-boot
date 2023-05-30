package com.nhnacademy.springboot.service;

import com.nhnacademy.springboot.repository.AccountRepository;
import com.nhnacademy.springboot.teacher.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultAccountService implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<Account> getAccounts() {
        return accountRepository.findAll();
    }

    @Transactional
    @Override
    public Account createAccount(Account account) {
        accountRepository.findById(account.getId()).ifPresent(
                s -> {
                    throw new RuntimeException("이미 존재하는 계좌입니다.");
                }
        );
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(
                () -> new RuntimeException("존재하지 않는 계좌입니다."));
    }

    @Transactional
    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}