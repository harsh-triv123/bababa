package com.travel_bnb.controller;

import com.travel_bnb.entity.AppUser;
import com.travel_bnb.payload.AppUserDto;
import com.travel_bnb.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
//    http://localhost:8080/api/v1/users/create-user
    @PostMapping("create-user")
    public ResponseEntity<AppUserDto> createUser(@RequestBody AppUser appUser){
        AppUserDto appUserDto = userService.createUser(appUser);
        return new ResponseEntity<>(appUserDto, HttpStatus.CREATED);
    }

}
