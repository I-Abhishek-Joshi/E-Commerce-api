package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

    Orders findByOrdersId(int ordersId);
}
