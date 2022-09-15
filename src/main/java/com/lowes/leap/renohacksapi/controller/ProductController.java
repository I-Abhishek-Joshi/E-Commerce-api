package com.lowes.leap.renohacksapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ProductController {

  //cd   @Autowired
//    KafkaTemplate<String, Product> KafkaJsonTemplate;
//    String TOPIC_NAME = "product_topic";

    @Autowired
    ProductService productService;

    //get all products
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }


    @PostMapping("/products")
    public void insertProduct(@RequestBody Product product){
        //KafkaJsonTemplate.send(TOPIC_NAME,product);
    }

    //Pagination By ID::
    @GetMapping("/products/{id}")
    public Page<Product> getAllItemsInLimit(@PathVariable Integer id) throws JsonProcessingException {
        return productService.getAllItemsInLimit(id);
    }



    //get products by id
    @GetMapping(value="/products/id/{productId}")
    public List<Product> getProductById(@PathVariable Integer productId)
    {
        return productService.getByProductId(productId);
    }

    //get products by name
    @GetMapping(value="/products/name/{productName}")
    public List<Product> findByProductName(@PathVariable String productName)
    {
        return productService.findByProductName(productName);
    }


}
