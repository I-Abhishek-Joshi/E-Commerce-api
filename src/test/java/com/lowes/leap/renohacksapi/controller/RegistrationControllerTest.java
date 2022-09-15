package com.lowes.leap.renohacksapi.controller;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.service.CustomerService;
import com.lowes.leap.renohacksapi.service.RegistrationService;
import com.lowes.leap.renohacksapi.service.UserService;
import com.lowes.leap.renohacksapi.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RegistrationController.class)
public class RegistrationControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    RegistrationService registrationService;

    @MockBean
    CustomerService customerService;

    @MockBean
    UserService userService;

    @MockBean
    KafkaTemplate kafkaTemplate;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthenticationManager authenticationManager;

    @Test
    void shouldBeRegisteredSuccessfully() throws Exception {
        List<Customer> customerList = new ArrayList<>();

        Customer customer = Customer.builder()
                .customerName("ascbfg")
                .customerId(1)
                .customerMobNo("9875567896")
                .customerEmail("xyz@gmail.com")
                .customerAddress("dbs3jhkx")
                .build();
        customerList.add(customer);

        Mockito.when(customerService.getAllCustomers()).thenReturn(customerList);

        mockMvc.perform(MockMvcRequestBuilders.post("/register")         //action and assertion
                        .content(new ObjectMapper().writeValueAsString(customer))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
