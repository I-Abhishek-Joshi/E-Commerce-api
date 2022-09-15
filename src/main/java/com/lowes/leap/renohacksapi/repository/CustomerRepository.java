package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer findByCustomerId(int customerId);
}
