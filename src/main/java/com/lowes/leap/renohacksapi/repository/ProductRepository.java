package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
//@Qualifier("product")
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByProductName(String productName);

    List<Product> getByProductId(Integer productId);
}


