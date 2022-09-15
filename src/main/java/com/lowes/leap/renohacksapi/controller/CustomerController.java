package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.repository.CustomerRepository;
import com.lowes.leap.renohacksapi.service.CustomerService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId){
        return customerService.getCustomerById(customerId);
    }
}
