package com.lowes.leap.renohacksapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orders")
@Builder
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int ordersId;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "orders_product",
            joinColumns = {@JoinColumn(name = "ordersId")},
            inverseJoinColumns = {@JoinColumn(name = "productId")})
    private List<Product> productInOrders;
}
