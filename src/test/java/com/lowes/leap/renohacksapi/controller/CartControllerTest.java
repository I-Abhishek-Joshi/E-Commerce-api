package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.entity.Product;

import com.lowes.leap.renohacksapi.model.CartDetails;
import com.lowes.leap.renohacksapi.service.CartProductService;
import com.lowes.leap.renohacksapi.service.CartService;
import com.lowes.leap.renohacksapi.service.UserService;
import com.lowes.leap.renohacksapi.utils.JwtUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(CartController.class)

class CartControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CartService cartService;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthenticationManager authenticationManager;

    @MockBean
    CartProductService cartProductService;


    @Test
    void shouldReturnCartDetailsWhenItsClicked() throws Exception {
     List<Cart> cartList = new ArrayList<>();
        Cart cart = Cart.builder().cartId(1).build();
        cartList.add(cart);
        CartDetails cartDetails = new CartDetails();
        cartDetails.setCartId(1);



        Mockito.when(cartService.getCartDetails(1)).thenReturn(cartDetails);


        mockMvc.perform(MockMvcRequestBuilders.get("/cart/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

}
