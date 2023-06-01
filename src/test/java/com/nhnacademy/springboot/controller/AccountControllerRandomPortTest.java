package com.nhnacademy.springboot.controller;


import com.nhnacademy.springboot.Account.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerRandomPortTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @Order(1)
    void testGetStudents() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Account> entity = new HttpEntity<>(headers);

        ResponseEntity<List<Account>> exchange = testRestTemplate.exchange(
                "/accounts",
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<Account>>() {
                });

        assertThat(exchange.getBody()).contains(new Account(1L, "100", 100));
    }

    @Test
    @Order(2)
    void testGetStudent() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Account> entity = new HttpEntity<>(headers);

        ResponseEntity<Account> exchange = testRestTemplate.exchange(
                "/accounts/{id}",
                HttpMethod.GET,
                entity,
                Account.class,
                1L);

        assertThat(exchange.getBody()).isEqualTo(new Account(1L, "100", 100));
    }

    @Test
    @Order(3)
    void createAccount() throws Exception {
        Account account = new Account(3L, "300", 300);

        ResponseEntity<Account> exchange = testRestTemplate.postForEntity(
                "/accounts",
                account,
                Account.class,
                1L);

        assertThat(exchange.getBody()).isEqualTo(account);
    }

}