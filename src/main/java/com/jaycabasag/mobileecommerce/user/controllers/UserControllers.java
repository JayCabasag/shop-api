package com.jaycabasag.mobileecommerce.user.controllers;

import com.jaycabasag.mobileecommerce.user.Services.UserServices;
import com.jaycabasag.mobileecommerce.user.User;
import com.jaycabasag.mobileecommerce.user.dto.UserDataRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserControllers {

    private final UserServices userServices;
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(@PathVariable("id") Long id){
        return userServices.getUser(id);
    }

    @PostMapping()
    public ResponseEntity<?> addUser(@RequestBody UserDataRequest request){
        return userServices.addUser(request);
    }

}
