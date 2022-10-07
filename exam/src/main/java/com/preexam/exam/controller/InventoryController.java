package com.preexam.exam.controller;

import com.preexam.exam.domain.Inventory;
import com.preexam.exam.dto.InvenotoryDTO;
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
@RequestMapping("getInvPicture")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public ResponseEntity getInvenotry(@RequestBody InvenotoryDTO invDTO) throws ExecutionException, InterruptedException {

        //log.debug("Reading the details from the request body");
        CompletableFuture<Inventory> inv = inventoryService.getInventory(invDTO.getProductid(), invDTO.getProdName(),invDTO.getAvailDate());

        InvenotoryDTO invenDTO=new InvenotoryDTO();
        invenDTO.getInventory(invenDTO.getProductid(),invenDTO.getProdName(),invenDTO.getAvailQty());
        return ResponseEntity.ok(invenDTO);

    }
}
