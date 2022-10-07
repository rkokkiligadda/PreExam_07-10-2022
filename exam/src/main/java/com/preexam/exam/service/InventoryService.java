package com.preexam.exam.service;

import com.preexam.exam.domain.Inventory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class InventoryService {

    @Async
    public CompletableFuture<com.preexam.exam.domain.Inventory> getInventory(String productId, String prodName, LocalDate reqDate) {
        log.debug("Hard coding the values");
        com.preexam.exam.domain.Inventory inv1=new Inventory("Prod1","Shirt","EACH", 10.0, LocalDate.parse("2021-03-19"));
        com.preexam.exam.domain.Inventory inv2=new Inventory("Prod1","Shirt","EACH", 20.0, LocalDate.parse("2021-03-21"));
        com.preexam.exam.domain.Inventory inv3=new Inventory("Prod1","Shirt","EACH", 20.0, LocalDate.parse("2021-03-28"));

        List<com.preexam.exam.domain.Inventory> invList = new ArrayList<>();
        invList.add(inv1) ;
        invList.add(inv2) ;
        invList.add(inv3) ;
        log.info("Order thread name is:", Thread.currentThread().getName());

        return CompletableFuture
                .completedFuture(invList
                        .stream()
                        .filter(i1 -> inv2.getProductId().equals(i1)).iterator().next());
    }


}
