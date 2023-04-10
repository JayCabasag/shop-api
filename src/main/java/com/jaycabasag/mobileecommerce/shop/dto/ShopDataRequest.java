package com.jaycabasag.mobileecommerce.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDataRequest {
    private String name;
    private String slug;
    private String description;
    private String address;
    private String phone;
    private String email;
    private String logo;
    private String website;
    private Boolean active;
    private String owner;
    private Integer totalProducts;
    private Date createdAt;
    private Date updatedAt;
}
