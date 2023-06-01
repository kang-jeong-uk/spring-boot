package com.nhnacademy.springboot.repository;

import com.nhnacademy.springboot.Account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findById(Long id);
}
