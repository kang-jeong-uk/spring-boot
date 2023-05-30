package com.nhnacademy.springboot.repository;

import com.nhnacademy.springboot.teacher.Account;

import java.util.List;

public interface AccountRepository {
    List<Account> findAll();
}
