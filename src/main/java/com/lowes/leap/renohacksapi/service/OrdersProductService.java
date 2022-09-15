package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.OrdersProduct;
import com.lowes.leap.renohacksapi.repository.OrdersProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersProductService {

    @Autowired
    OrdersProductRepository ordersProductRepository;

    @Autowired
    CartService cartService;

    public List<OrdersProduct> getAllFromOrders(int ordersId) {
        return ordersProductRepository.findByOrdersOrdersId(ordersId);
    }
}
