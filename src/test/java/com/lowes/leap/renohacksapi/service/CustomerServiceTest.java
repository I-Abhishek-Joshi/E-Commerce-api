package com.lowes.leap.renohacksapi.service;


import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.repository.CustomerRepository;
import com.lowes.leap.renohacksapi.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {
    @InjectMocks
    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;

    @Test
    void shouldGetCustomerDetails(){
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

        List<Customer> validCustomers = customerService.getAllCustomers();
        assertEquals(customerDetailsList, validCustomers);

    }


}
