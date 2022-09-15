package com.lowes.leap.renohacksapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowes.leap.renohacksapi.entity.Category;
import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.service.ProductService;
import com.lowes.leap.renohacksapi.service.UserService;
import com.lowes.leap.renohacksapi.utils.JwtRequestFilter;
import com.lowes.leap.renohacksapi.utils.JwtUtils;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductController.class)

class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ProductService productService;

    @MockBean
    UserService userService;

    @MockBean
    KafkaTemplate kafkaTemplate;

    @MockBean
    JwtUtils jwtUtils;

    @MockBean
    AuthenticationManager authenticationManager;





    @Test
    void shouldReturnOkWhenAllProductsAreRequested() throws Exception {
        List<Product> products = new ArrayList<>();



//        Product product = Product.builder()
//                .productId(1)
//                .productName("Iphone 13")
//                .category(category)
//                .productDescription("Very Expensive")
//                .productModelNo("5647")
//                .productPrice(12000.0F)
//                .productQuantity(3)
//                .productFeature("hkjhjh")
//                .build();
//        products.add(product);
        Product product = Product.builder()
                .productId(1)
                .productName("Iphone 13")
                .productDescription("Very Expensive")
                .productModelNo("5647")
                .productPrice(12000.0F)
                .productQuantity(3)
                .productFeature("hkjhjh")
                .build();
        products.add(product);

        Mockito.when(productService.getAllProducts()).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("/products"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].productId").value(1))
                .andExpect(MockMvcResultMatchers.content().json(new ObjectMapper().writeValueAsString(products
                )));

    }

    //get product by product_name
    @Test
    void testThatWhenGetProductNameThenGetProduct() throws Exception {
        List<Product> products = new ArrayList<>();


        Product product = Product.builder()
                .productId(1)
                .productName("Pelham Bay Rectangle Outdoor Dining Table 38-in W x 60-in L with Umbrella Hole")
                .productDescription("Very Expensive")
                .productModelNo("5647")
                .productPrice(12000.0F)
                .productQuantity(3)
                .productFeature("hkjhjh")
                .build();
        products.add(product);

        Mockito.when(productService.findByProductName("Pelham Bay Rectangle Outdoor Dining Table 38-in W x 60-in L with Umbrella Hole")).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/products/name/Pelham Bay Rectangle Outdoor Dining Table 38-in W x 60-in L with Umbrella Hole"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    //get product by product_id
    @Test
    void testThatWhenGetProductIdThenGetProduct() throws Exception {
        List<Product> products = new ArrayList<>();


        Product product = Product.builder()
                .productId(1)
                .productName("Pelham Bay Rectangle Outdoor Dining Table 38-in W x 60-in L with Umbrella Hole")
                .productDescription("Very Expensive")
                .productModelNo("5647")
                .productPrice(12000.0F)
                .productQuantity(3)
                .productFeature("hkjhjh")
                .build();
        products.add(product);

        Mockito.when(productService.getByProductId(1)).thenReturn(products);

        mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/products/id/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}