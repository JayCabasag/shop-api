package com.jaycabasag.mobileecommerce.user.Services;

import com.jaycabasag.mobileecommerce.user.User;
import com.jaycabasag.mobileecommerce.user.UserRepository;
import com.jaycabasag.mobileecommerce.user.dto.UserDataRequest;
import com.jaycabasag.mobileecommerce.user.dto.UserDataResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServices {
    private final UserRepository userRepository;
    public ResponseEntity<?> getUser(Long id){
        if (!isUserExists(id)){
            UserDataResponse response = new UserDataResponse("User does not exists");
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
        User user = userRepository.findById(id).orElseThrow();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public boolean isUserExists(Long id){
        Optional<User> user = userRepository.findUserById(id);
        return user.isPresent();
    }

    public ResponseEntity<?> addUser(UserDataRequest request){
        if(isUserEmailExists(request.getEmail())){
            UserDataResponse response = new UserDataResponse("Email already used.");
            return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
        }
        if (isUserPhoneNumberExists(request.getPhoneNumber())){
            UserDataResponse response = new UserDataResponse("Phone number already used.");
            return new ResponseEntity<>(response, HttpStatus.ALREADY_REPORTED);
        }

        User newUser = User
                .builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .address(request.getAddress())
                .deliveryAddress(request.getDeliveryAddress())
                .cartId(request.getCartId())
                .build();

        User savedUser = userRepository.save(newUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    public boolean isUserEmailExists(String email){
        Optional<User> optionalUser = userRepository.findUserByEmail(email);
        return optionalUser.isPresent();
    }

    public boolean isUserPhoneNumberExists(String phoneNumber) {
        Optional<User> optionalUser = userRepository.findUserByPhoneNumber(phoneNumber);
        return optionalUser.isPresent();
    }

}
