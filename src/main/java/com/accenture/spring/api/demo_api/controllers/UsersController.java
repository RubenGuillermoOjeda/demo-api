package com.accenture.spring.api.demo_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.spring.api.demo_api.models.User;
import com.accenture.spring.api.demo_api.services.users.UserServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(defaultValue = "false", required = false) Boolean active) {
        List<User> users = active ? userService.getActiveUsers() : userService.getUsers();
        return ResponseEntity.ok(users);
    }
    
}
