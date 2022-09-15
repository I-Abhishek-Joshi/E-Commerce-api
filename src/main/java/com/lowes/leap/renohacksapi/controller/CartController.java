package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.model.CartDetails;
import com.lowes.leap.renohacksapi.service.CartProductService;
import com.lowes.leap.renohacksapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @Autowired
    CartProductService cartProductService;

    @GetMapping("/cart/{cartId}")
    public CartDetails getCartDetails(@PathVariable int cartId){
        return cartService.getCartDetails(cartId);
    }

}
