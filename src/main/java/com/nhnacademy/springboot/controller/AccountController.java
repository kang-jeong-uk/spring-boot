package com.nhnacademy.springboot.controller;

import com.nhnacademy.springboot.service.AccountService;
import com.nhnacademy.springboot.teacher.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountService.getAccounts();
    }

    @PostMapping("/accounts")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @GetMapping("/accounts/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    @DeleteMapping("/accounts/{id}")
    public String deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
        return "{\"result\":\"OK\"}";

    }
}
