package com.jaycabasag.mobileecommerce.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private Long shop;
    private String name;
    private String image;
    private String description;
    private String brand;
    private Double price;

    public Product(Long shop, String name, String image, String description, String brand, Double price) {
        this.shop = shop;
        this.name = name;
        this.image = image;
        this.description = description;
        this.brand = brand;
        this.price = price;
    }
}
