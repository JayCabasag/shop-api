package com.jaycabasag.mobileecommerce.product.services;

import com.jaycabasag.mobileecommerce.product.Product;
import com.jaycabasag.mobileecommerce.product.ProductRepository;
import com.jaycabasag.mobileecommerce.product.dto.ProductDataRequest;
import com.jaycabasag.mobileecommerce.product.dto.ProductDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServices {
    private final ProductRepository productRepository;
    public ResponseEntity<?> getProduct(Long id){
      if(!isProductExists(id)){
          ProductDataResponse response = new ProductDataResponse("Product not found");
          return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
      }
        Product productResponse = productRepository.findById(id).orElseThrow();
        return  new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    public boolean isProductExists(Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        return optionalProduct.isPresent();
    }
    public ResponseEntity<?> addProduct(ProductDataRequest request){
        var product = Product.builder()
                .shop(request.getShop())
                .name(request.getName())
                .brand(request.getBrand())
                .description(request.getDescription())
                .image(request.getImage())
                .price(request.getPrice())
                .build();
        productRepository.save(product);
        ProductDataResponse response = new ProductDataResponse("Added product successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
