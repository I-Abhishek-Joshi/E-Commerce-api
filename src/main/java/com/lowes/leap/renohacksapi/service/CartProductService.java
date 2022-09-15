package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.repository.CartProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartProductService {
    @Autowired
    CartProductRepository cartProductRepository;

    @Autowired
    CartService cartService;

    @Autowired
    ProductService productService;

    public CartProduct findCartProduct(int cartId, int productId){
        List<CartProduct> allCartProduct = cartProductRepository.findAll();

        CartProduct cartProduct = null;
        for(int i = 0; i < allCartProduct.size(); i++){
            if(allCartProduct.get(i).getCart().getCartId() == cartId && allCartProduct.get(i).getProduct().getProductId() == productId){
                cartProduct = allCartProduct.get(i);
            }
        }
        return cartProduct;
    }
    public void removeProductFromCart(int cartProductId) {
        cartProductRepository.deleteById(cartProductId);
    }

    public CartProduct addProductToCart(int cartId, int productId) {
        CartProduct cartProduct = findCartProduct(cartId, productId);

        if(cartProduct == null){
//            cartProduct = new CartProduct(cartId, productId, 1);
            Cart cart = cartService.getByCartId(cartId);
            Product product = (Product) productService.getByProductId(productId);

            cartProduct = CartProduct.builder()
                    .cart(cart)
                    .product(product)
                    .productQuantity(1)
                    .build();

        }else{
            cartProduct.setProductQuantity(cartProduct.getProductQuantity() + 1);
        }
        return cartProductRepository.save(cartProduct);
    }

    public List<CartProduct> getAllFromCart(int cartId) {
        return cartProductRepository.findByCartCartId(cartId);
    }


    public CartProduct increaseProductFromCart(int cartProductId) {

        CartProduct cartProduct = cartProductRepository.getById(cartProductId);
        cartProduct.setProductQuantity(cartProduct.getProductQuantity() + 1);
        return cartProductRepository.save(cartProduct);
    }

    public CartProduct decreaseProductFromCart(int cartProductId) {
        CartProduct cartProduct = cartProductRepository.getById(cartProductId);
        cartProduct.setProductQuantity(cartProduct.getProductQuantity() - 1);
        return cartProductRepository.save(cartProduct);
    }

    public List<CartProduct> getByCartId(int cartId) {
        return  cartProductRepository.findByCartCartId(cartId);
    }
}
