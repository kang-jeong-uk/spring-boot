package com.nhnacademy.springboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.springboot.Account.Account;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc // @SpringBootTest(MOCK)을 사용할 때 의존성을 주입하여 준다. 디폴트값도 목이기 때문에 넣어야 한다.
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AccountControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1) // 스프링 빈의 순서를 정한다.
    void testGetAccounts() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].id", equalTo(1)));
    }

    @Test
    @Order(2) // 스프링 빈의 순서를 정한다.
    void testGetAccount() throws Exception {
        mockMvc.perform(get("/accounts/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(1)));
    }

    @Test
    @Order(3) // 스프링 빈의 순서를 정한다.
    void testCreateAccount() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Account account = new Account(4L, "400", 400);
        mockMvc.perform(post("/accounts")
                        .content(objectMapper.writeValueAsString(account))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo(4)));
    }

    @Test
    @Order(4) // 스프링 빈의 순서를 정한다.
    void testDeleteAccount() throws Exception {
        mockMvc.perform(delete("/accounts/{id}", 4L))
                .andExpect(status().isOk())

                //수정필요
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", equalTo("OK")));
    }

}