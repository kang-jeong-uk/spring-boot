package com.nhnacademy.springboot.Account;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@EqualsAndHashCode
@ToString
@Entity
public class Account {
    @Id
    private Long id;
    private String number;
    private Integer balance;

    public Account(Long id, String number, Integer balance) {
        this.id = id;
        this.number = number;
        this.balance = balance;
    }

    public Account() {

    }
}
