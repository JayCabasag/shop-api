package com.jaycabasag.mobileecommerce.shop.controllers;

import com.jaycabasag.mobileecommerce.shop.dto.ShopDataRequest;
import com.jaycabasag.mobileecommerce.shop.services.ShopServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ShopControllers {
    private final ShopServices shopServices;
    @GetMapping("/shops")
    public ResponseEntity<?> getAllShops(){
        return new ResponseEntity<>(shopServices.getAllShops(), HttpStatus.OK);
    }
    @PostMapping("/shop")
    public ResponseEntity<?> addShop(@RequestBody ShopDataRequest request){
        return shopServices.addShop(request);
    }
    @GetMapping("/shop/{id}")
    public ResponseEntity<?> getShop(@PathVariable("id") Long id){
        return shopServices.getShop(id);
    }
}
