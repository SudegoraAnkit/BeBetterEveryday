package com.nexcommerce.user_service.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcommerce.user_service.model.entity.User;

@RestController
@RequestMapping("/api/users")
public class UserController {
    

    public List<User> getAllUsers(){
        
    }
}
