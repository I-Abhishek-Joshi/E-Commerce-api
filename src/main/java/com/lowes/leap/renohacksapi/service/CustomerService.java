package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Customer;
import com.lowes.leap.renohacksapi.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public Customer addNewCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer addanotherC(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer getCustomerById(int customerId) {
        return customerRepository.findByCustomerId(customerId);
    }
}
