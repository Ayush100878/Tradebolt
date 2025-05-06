package com.example.tradebolt.controller;

import com.example.tradebolt.config.JwtConstant;
import com.example.tradebolt.Modal.User;
import com.example.tradebolt.domain.VerificationType;
import com.example.tradebolt.response.ApiResponse;
import com.example.tradebolt.response.AuthResponse;
import com.example.tradebolt.service.UserService;
import com.example.tradebolt.utils.OtpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController  {

    @Autowired
    private UserService userService;


    private String jwt;


    @GetMapping("/api/users/profile")
    public ResponseEntity<User> getUserProfile(@RequestHeader(JwtConstant.JWT_HEADER) String jwt) throws Exception {
        User user = userService.findUserProfileByJwt(jwt);

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }


}
