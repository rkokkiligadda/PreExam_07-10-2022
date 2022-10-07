package com.preexam.exam.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvenotoryDTO {

    private String productid;
    private String prodName;
    private String UOM ;
    private Double availQty;
    private LocalDate availDate;

    public void getInventory(String productid, String prodName, Double availQty) {
    }
}
