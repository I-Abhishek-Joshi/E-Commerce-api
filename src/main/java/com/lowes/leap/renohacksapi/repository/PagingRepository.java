package com.lowes.leap.renohacksapi.repository;

import com.lowes.leap.renohacksapi.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.lowes.leap.renohacksapi.repository.ProductRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;


@Repository
public interface PagingRepository extends PagingAndSortingRepository<Product, Integer> {
//    @Autowired
//    ProductRepository productRepository;
//
//        default List<Product> findAllById(int pageNo, int pageSize) {
//            Pageable paging = PageRequest.of(pageNo, pageSize);
//            Page<Product> pagedResult = productRepository.findAll(paging);
//            return pagedResult.toList();
//        }

//List<Product> findAllByProductId(int product_id,Pageable pageable);

    Page<Product> findAll(Pageable pageable);
}
