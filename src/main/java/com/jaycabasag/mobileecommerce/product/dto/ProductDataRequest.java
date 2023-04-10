package com.jaycabasag.mobileecommerce.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDataRequest {
    private Long shop;
    private String name;
    private String image;
    private String description;
    private String brand;
    private Double price;
}
