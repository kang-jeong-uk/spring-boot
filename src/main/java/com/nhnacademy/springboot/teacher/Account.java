package com.nhnacademy.springboot.teacher;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
@ToString
public class Account {
    private final String number;
    private final Integer balance;
}
