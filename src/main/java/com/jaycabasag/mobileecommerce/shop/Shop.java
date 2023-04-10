package com.jaycabasag.mobileecommerce.shop;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "shops")
@Entity
public class Shop {
    @Id
    @GeneratedValue
    private Long id;
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

    public Shop(String name, String slug, String description, String address, String phone, String email, String logo, String website, Boolean active, String owner, Integer totalProducts, Date createdAt, Date updatedAt) {
        this.name = name;
        this.slug = slug;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.logo = logo;
        this.website = website;
        this.active = active;
        this.owner = owner;
        this.totalProducts = totalProducts;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
