package com.jaycabasag.mobileecommerce.product.controllers;

import com.jaycabasag.mobileecommerce.product.dto.ProductDataRequest;
import com.jaycabasag.mobileecommerce.product.services.ProductServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductControllers {
    private final ProductServices productServices;
    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable("id") Long id){
        return productServices.getProduct(id);
    }
    @GetMapping("/products")
    public ResponseEntity<?> getShopProducts(@RequestParam("shop") Long id){
        return productServices.getShopProducts(id);
    }
    @GetMapping("/all-products")
    public ResponseEntity<?> getProducts(@RequestParam(name = "limit", defaultValue = "10") Integer limit){
        return productServices.getAllProducts(limit);
    }
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestBody ProductDataRequest request){
        return productServices.addProduct(request);
    }
}
