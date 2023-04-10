package com.jaycabasag.mobileecommerce.shop.services;

import com.jaycabasag.mobileecommerce.shop.Shop;
import com.jaycabasag.mobileecommerce.shop.ShopRepository;
import com.jaycabasag.mobileecommerce.shop.dto.ShopDataRequest;
import com.jaycabasag.mobileecommerce.shop.dto.ShopDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ShopServices {
    private final ShopRepository shopRepository;
    public List<Shop> getAllShops(){
        List<Shop> allShops = shopRepository.findAll();
        return allShops;
    }
    public ResponseEntity<?> addShop(ShopDataRequest request){
        if (isShopExists(request.getSlug())){
            ShopDataResponse response = ShopDataResponse.builder()
                    .message("Shop already exists")
                    .build();
            return  new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
        }
        var shop = Shop.builder()
                .name(request.getName())
                .slug(request.getSlug())
                .description(request.getDescription())
                .address(request.getAddress())
                .phone(request.getPhone())
                .email(request.getEmail())
                .logo(request.getLogo())
                .website(request.getWebsite())
                .active(request.getActive())
                .owner(request.getOwner())
                .totalProducts(request.getTotalProducts())
                .createdAt(new Date())
                .updatedAt(new Date())
                .build();
        shopRepository.save(shop);
        ShopDataResponse response = ShopDataResponse.builder()
                .message("Shop added successfully")
                .build();
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    public boolean isShopExists(String shopSlug){
        Optional<Shop> optionalShop = shopRepository.findShopBySlug(shopSlug);
        return optionalShop.isPresent();
    }

    public ResponseEntity<?> getShop(Long id) {
        if (!shopRepository.findById(id).isPresent()){
            ShopDataResponse notFoundResponse = new ShopDataResponse("Shop does not exist.");
            return new ResponseEntity<>(notFoundResponse, HttpStatus.OK);
        }
        var shopResponse = shopRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(shopResponse, HttpStatus.OK);
    }
}
