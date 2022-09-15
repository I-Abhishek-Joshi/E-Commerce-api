package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.CartProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartProductRepository extends JpaRepository<CartProduct, Integer> {
    List<CartProduct> findByCartCartId(int cartId);

    CartProduct findByCartProductId(int cartProductId);
}
