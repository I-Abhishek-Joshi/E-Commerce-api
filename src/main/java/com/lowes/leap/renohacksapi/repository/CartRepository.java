package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.Cart;
import com.lowes.leap.renohacksapi.model.CartDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    Cart findByCartId(int cartId);
}
