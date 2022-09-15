package com.lowes.leap.renohacksapi.service;



import com.lowes.leap.renohacksapi.entity.OrdersProduct;

import com.lowes.leap.renohacksapi.repository.OrdersProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class OrdersProductServiceTest {
    @InjectMocks
    OrdersProductService ordersProductService;

    @Mock
    OrdersProductRepository ordersProductRepository;

    @Mock
    CartService cartService;

    @Test
    void shouldReturnOrdersProduct(){
        List<OrdersProduct> ordersProductList = new ArrayList<>();

        OrdersProduct ordersProduct = OrdersProduct.builder()
                .ordersProductId(1)
                .productQuantity(2)
                .build();
        ordersProductList.add(ordersProduct);

        Mockito.when(ordersProductService.getAllFromOrders(1)).thenReturn(ordersProductList);

        List<OrdersProduct> actualOrdersProducts = ordersProductService.getAllFromOrders(1);
        assertEquals(ordersProductList, actualOrdersProducts);

    }

}
