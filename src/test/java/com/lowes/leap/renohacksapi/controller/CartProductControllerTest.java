package com.lowes.leap.renohacksapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.service.CartProductService;
import com.lowes.leap.renohacksapi.service.UserService;
import com.lowes.leap.renohacksapi.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CartProductController.class)
public class CartProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CartProductService cartProductService;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthenticationManager authenticationManager;


    @Test
    void shouldReturnCartProductDetailsWhenSearchedByCartId() throws Exception {
        List<CartProduct> cartProducts = new ArrayList<>();

        CartProduct cartProduct = CartProduct.builder()
                .cartProductId(1)
                .cartProductId(1)
                .productQuantity(2)
                .build();
        cartProducts.add(cartProduct);




        Mockito.when(cartProductService.getAllFromCart(1)).thenReturn(cartProducts);




        mockMvc.perform(MockMvcRequestBuilders.post("/cart/1/product/1")         //action and assertion
                        .content(new ObjectMapper().writeValueAsString(cartProduct))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());




    }
}