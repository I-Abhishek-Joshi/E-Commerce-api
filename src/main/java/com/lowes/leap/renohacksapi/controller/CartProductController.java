package com.lowes.leap.renohacksapi.controller;

import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.service.CartProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartProductController {
    @Autowired
    CartProductService cartProductService;

    @PostMapping("/cart/{cartId}/product/{productId}")
    public CartProduct addProductToCart(@PathVariable int cartId, @PathVariable int productId){
        return cartProductService.addProductToCart(cartId, productId);
    }

    @DeleteMapping("/cart/product/{cartProductId}/remove")
    public void removeProductFromCart(@PathVariable int cartProductId){
        cartProductService.removeProductFromCart(cartProductId);
    }
    @PatchMapping("/cart/product/{cartProductId}/quantity/update/increase")
    public CartProduct increaseProductFromCart(@PathVariable int cartProductId){
        return cartProductService.increaseProductFromCart(cartProductId);
    }
    @PatchMapping("/cart/product/{cartProductId}/quantity/update/decrease")
    public CartProduct decreaseProductFromCart(@PathVariable int cartProductId){
        return cartProductService.decreaseProductFromCart(cartProductId);
    }
}

