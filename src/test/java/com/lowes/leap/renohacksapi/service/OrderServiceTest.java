package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.OrdersProduct;

import com.lowes.leap.renohacksapi.repository.OrdersProductRepository;
import com.lowes.leap.renohacksapi.repository.OrdersRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;




@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {

    @InjectMocks
    OrdersService ordersService;

    @Mock
    OrdersRepository ordersRepository;

    @Mock
    OrdersProductRepository ordersProductRepository;


    @Test
    void shouldGetOrderHistory(){
        OrdersProduct ordersProduct = OrdersProduct.builder().ordersProductId(1).productQuantity(2).build();
        List<OrdersProduct> ordersProductList = new ArrayList<>();
        ordersProductList.add(ordersProduct);

        int ordersId = 1;

        Mockito.when(ordersProductRepository.findByOrdersOrdersId(ordersId)).thenReturn(ordersProductList);
        ordersProductRepository.findByOrdersOrdersId(ordersId);
        Mockito.verify(ordersProductRepository, Mockito.times(1)).findByOrdersOrdersId(ordersId);

    }
}
