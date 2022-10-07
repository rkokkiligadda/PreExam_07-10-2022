package com.preexam.exam.controller;

import com.preexam.exam.domain.Products;
import com.preexam.exam.dto.ProductsDTO;
import com.preexam.exam.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("sortProducts")
public class ProductController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity getProductList(@RequestBody Products products) throws ExecutionException, InterruptedException {

        log.debug("Reading the list of Products from the Input");
        CompletableFuture<Products> inv = inventoryService.getInventory(products.);

        ProductsDTO productsDTO=new ProductsDTO();
        productsDTO.getProduct(products);
        return ResponseEntity.ok(productsDTO);
    }
}
