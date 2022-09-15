package com.lowes.leap.renohacksapi.controller;


import com.lowes.leap.renohacksapi.entity.OrdersProduct;
import com.lowes.leap.renohacksapi.model.OrdersDetails;
import com.lowes.leap.renohacksapi.service.CartService;
import com.lowes.leap.renohacksapi.service.OrdersProductService;
import com.lowes.leap.renohacksapi.service.OrdersService;
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
@WebMvcTest(OrdersController.class)
public class OrderControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    OrdersService ordersService;

    @MockBean
    UserService userService;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthenticationManager authenticationManager;

    @MockBean
    OrdersProductService ordersProductService;

    @Test
    void shouldReturnProductWhenOrdered() throws Exception {
        List<OrdersProduct> ordersProductList = new ArrayList<>();

        OrdersProduct ordersProduct = OrdersProduct.builder().productQuantity(2).ordersProductId(1).build();
        ordersProductList.add(ordersProduct);

        OrdersDetails ordersDetails = new OrdersDetails();
        ordersDetails.setOrdersId(1);

        Mockito.when(ordersService.getOrdersDetails(1)).thenReturn(ordersDetails);

        mockMvc.perform(MockMvcRequestBuilders.get("/orders/cart/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());


    }

}
