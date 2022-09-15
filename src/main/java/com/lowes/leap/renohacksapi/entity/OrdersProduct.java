package com.lowes.leap.renohacksapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "orders_product")
public class OrdersProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_product_id")
    private int ordersProductId;

    @ManyToOne
    @JoinColumn(name = "ordersId")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "productId")
    private Product product;

    @Column(name = "product_quantity")
    private int productQuantity;
}
