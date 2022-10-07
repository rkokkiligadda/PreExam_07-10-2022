package com.preexam.exam.dto;

import com.preexam.exam.domain.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductsDTO {
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;
}

