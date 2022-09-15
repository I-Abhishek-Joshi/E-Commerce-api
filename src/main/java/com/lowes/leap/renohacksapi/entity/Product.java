package com.lowes.leap.renohacksapi.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productId;
    private String productName;
    private String productDescription;
    private String productFeature;
    private Float productPrice;
    private String productModelNo;
    private int productQuantity;


//
//    @ManyToMany(mappedBy = "productInCart")
//    @JsonBackReference
//    private List<Cart> cartsProduct;
//
//    @ManyToMany(mappedBy = "productInOrders")
//    @JsonBackReference
//    private List<Orders> ordersProduct;

}
