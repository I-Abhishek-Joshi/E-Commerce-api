package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.OrdersProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersProductRepository extends JpaRepository<OrdersProduct, Integer> {
    List<OrdersProduct> findByOrdersOrdersId(int ordersId);
}
