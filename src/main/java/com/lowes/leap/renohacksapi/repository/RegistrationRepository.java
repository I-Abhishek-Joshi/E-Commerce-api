package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Customer, Integer> {
}
