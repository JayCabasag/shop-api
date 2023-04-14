package com.jaycabasag.mobileecommerce.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDataRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;
    private List<String> address;
    private String deliveryAddress;
    private Long cartId;
}
