package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {

    @Autowired
    RegistrationRepository registrationRepository;

    public Customer registerUser(Customer customer) {
        return registrationRepository.save(customer);
    }
}
