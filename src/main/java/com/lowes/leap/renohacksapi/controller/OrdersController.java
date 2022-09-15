package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.Orders;
import com.lowes.leap.renohacksapi.model.OrdersDetails;
import com.lowes.leap.renohacksapi.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    @Autowired
    OrdersService ordersService;

    @PostMapping("/orders/{cartId}/{ordersId}")
    public void addAllProductsFromCartToOrders(@PathVariable int cartId, @PathVariable int ordersId){
        ordersService.addAllProductsFromCartToOrders(cartId, ordersId);
    }

    @GetMapping("/orders/cart/{orderId}")
    public OrdersDetails getOrdersDetails(@PathVariable int orderId){
        return ordersService.getOrdersDetails(orderId);
    }
}
