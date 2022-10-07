package com.preexam.exam.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {

    private String productId ;
    private String prodName;
    private String UOM ;
    private Double availQty;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate availDate;

}

