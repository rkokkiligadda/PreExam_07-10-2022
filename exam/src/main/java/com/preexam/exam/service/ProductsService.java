package com.preexam.exam.service;

import com.preexam.exam.domain.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import com.preexam.exam.domain.Products;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class ProductsService {

    @Async
    public CompletableFuture<Product> getProduct(Products Products) {
        log.debug("Hard coding the values");
        Product p1=new Product("Prod2","Trousers","EACH", LocalDate.parse("2021-03-19"));
        Product p2=new Product("Prod1","Shirt","EACH", LocalDate.parse("2021-03-19"));
        Product p3=new Product("Prod3","Tie","EACH", LocalDate.parse("2021-03-19"));

        List<Product> invList = new ArrayList<>();
        invList.add(p1) ;
        invList.add(p2) ;
        invList.add(p3) ;
        log.info("Order thread name is:", Thread.currentThread().getName());

        log.debug("Sorting the products") ;
        return CompletableFuture
                .completedFuture(invList
                        .stream()
                        .filter(o1 -> p2.getProductId().equals(p2)).sorted().iterator().next());

    }


}
