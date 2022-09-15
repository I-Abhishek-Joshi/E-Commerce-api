package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.model.CartDetails;
import com.lowes.leap.renohacksapi.model.ProductCartDetails;
import com.lowes.leap.renohacksapi.repository.CartProductRepository;
import com.lowes.leap.renohacksapi.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;


    @Autowired
    CartProductRepository cartProductRepository;

    public Cart addNewCart() {
        Cart newCart = new Cart();
        return cartRepository.save(newCart);
    }

    public Cart getByCartId(int cartId) {
        return cartRepository.findByCartId(cartId);
    }

    public CartDetails getCartDetails(int cartId) {
        List<CartProduct> allCartProduct = cartProductRepository.findByCartCartId(cartId);
        CartDetails cartDetails = new CartDetails();
        cartDetails.setCartId(cartId);
        ArrayList<ProductCartDetails> productCartDetailsList = new ArrayList<>();

        for(int i = 0; i < allCartProduct.size(); i++){
            CartProduct currCartProduct = allCartProduct.get(i);
            ProductCartDetails productCartDetails = new ProductCartDetails();
            productCartDetails.setProductId(currCartProduct.getProduct().getProductId());
            productCartDetails.setProductName(currCartProduct.getProduct().getProductName());
            productCartDetails.setProductDescription(currCartProduct.getProduct().getProductDescription());
            productCartDetails.setProductPrice(currCartProduct.getProduct().getProductPrice());
            productCartDetails.setProductModelNo(currCartProduct.getProduct().getProductModelNo());
            productCartDetails.setProductCartQuantity(currCartProduct.getProductQuantity());
            productCartDetails.setProductFeature(currCartProduct.getProduct().getProductFeature());
            productCartDetails.setCartProductId(currCartProduct.getCartProductId());

            productCartDetailsList.add(productCartDetails);
        }
        cartDetails.setProductCartDetailsList(productCartDetailsList);
        return cartDetails;
    }


}
