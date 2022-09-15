package com.lowes.leap.renohacksapi.controller;


import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.service.CartProductService;
import com.lowes.leap.renohacksapi.service.CustomerService;
import com.lowes.leap.renohacksapi.service.UserService;
import com.lowes.leap.renohacksapi.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CustomerService customerService;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthenticationManager authenticationManager;

    @Test
    void shouldGetAllDetailsOfCustomers() throws Exception {
        List<Customer> customerDetailsList = new ArrayList<>();

        Customer customer = Customer.builder()
                .customerId(1)
                .customerAddress("awdsd")
                .customerEmail("abc@gmail.com")
                .customerMobNo("9876543210")
                .customerName("supal")
                .build();
        customerDetailsList.add(customer);

        Mockito.when(customerService.getAllCustomers()).thenReturn(customerDetailsList);

        mockMvc.perform(MockMvcRequestBuilders.get("/customers/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }
}
