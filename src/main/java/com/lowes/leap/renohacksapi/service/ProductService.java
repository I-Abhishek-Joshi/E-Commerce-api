package com.lowes.leap.renohacksapi.service;

import com.lowes.leap.renohacksapi.entity.Product;
import com.lowes.leap.renohacksapi.repository.PagingRepository;
import com.lowes.leap.renohacksapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    PagingRepository pagingRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }


    public Page<Product> getAllItemsInLimit(Integer page_number) {

        int pageNumber = page_number - 1;
        int pageSize = 5;
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Product> result = pagingRepository.findAll(pageable);
        return pagingRepository.findAll(pageable);
        //System.out.println("ABC :: "+result);
        // return productRepository.findByProductId(product_id);
    }




    public List<Product> findByProductName (String productName){
        return  productRepository.findByProductName(productName);
    }


    public List<Product> getByProductId(Integer productId) {
        return productRepository.getByProductId(productId);



    }

}
