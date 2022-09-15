package com.lowes.leap.renohacksapi.service;


import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.repository.RegistrationRepository;
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
public class RegistrationServiceTest {

    @InjectMocks
    RegistrationService registrationService;

    @Mock
    RegistrationRepository registrationRepository;

    @Mock
    CustomerService customerService;

    @Test
    void shouldGetRegisteredByCustomers() {
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

        List<Customer> actualRegisteredCustomers = customerService.getAllCustomers();
        assertEquals(customerList, actualRegisteredCustomers);
    }

}
