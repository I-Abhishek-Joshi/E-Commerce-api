package com.lowes.leap.renohacksapi.service;


import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.entity.CartProduct;
import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.repository.CartProductRepository;
import com.lowes.leap.renohacksapi.repository.CartRepository;
import org.junit.jupiter.api.Test;


import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;




import java.util.ArrayList;
import java.util.List;



@ExtendWith(MockitoExtension.class)
class CartServiceTest {
    @InjectMocks
    CartService cartService;

    @Mock
    CartRepository cartRepository;



   @Mock
    CartProductRepository cartProductRepository;









    @Test
    void shouldReturnAllCarts() {
        CartProduct cartProduct = CartProduct.builder().cartProductId(1).product(Product.builder().build()).productQuantity(1).cart(Cart.builder().build()).cartProductId(1).build();
        List<CartProduct> cartProductList = new ArrayList<>();

        int cartId=1;

        Mockito.when(cartProductRepository.findByCartCartId(cartId)).thenReturn(cartProductList);
        cartProductRepository.findByCartCartId(cartId);
        Mockito.verify(cartProductRepository, Mockito.times(1)).findByCartCartId(cartId);

    }

}
