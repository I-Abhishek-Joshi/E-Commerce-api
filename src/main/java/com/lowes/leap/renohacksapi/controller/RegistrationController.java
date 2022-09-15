package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class RegistrationController {

    @Autowired
    RegistrationService registrationService;

    @PostMapping("/register")
    public Customer registerUser(@RequestBody Customer customer){
        return registrationService.registerUser(customer);
    }
}
