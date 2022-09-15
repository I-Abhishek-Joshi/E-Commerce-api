package com.lowes.leap.renohacksapi.service;


import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.repository.CartProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.lowes.leap.renohacksapi.entity.Cart;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)

public class CartProductServiceTest {
    @InjectMocks
    CartProductService cartProductService;

    @Mock

    CartProductRepository cartProductRepository;



    @Test
    void shouldReturnAllCartsProducts(){
        List<CartProduct> cartProducts = new ArrayList<>();

        CartProduct cartProduct = CartProduct.builder()
                .cartProductId(1)
                .cartProductId(1)
                .productQuantity(2)
                .build();
        cartProducts.add(cartProduct);




        Mockito.when(cartProductService.getAllFromCart(1)).thenReturn(cartProducts);


        List<CartProduct> actualCartsProducts = cartProductService.getAllFromCart(1);

        assertEquals(cartProducts, actualCartsProducts);



    }
}