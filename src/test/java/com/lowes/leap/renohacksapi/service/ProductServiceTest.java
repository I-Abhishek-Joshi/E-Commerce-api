package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Category;
import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Test
    void shouldReturnAllProducts() {

        List<Product> products = new ArrayList<>();
        Category category = Category.builder()
                .categoryId(12)
                .categoryName("Phones")
                .build();

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



        Mockito.when(productService.getAllProducts()).thenReturn(products);

        List<Product> actualProducts = productService.getAllProducts();
        assertEquals(products, actualProducts);

    }
}