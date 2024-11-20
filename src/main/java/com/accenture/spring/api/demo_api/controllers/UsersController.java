package com.accenture.spring.api.demo_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.accenture.spring.api.demo_api.generated.controller.UserOperationsApi;
import com.accenture.spring.api.demo_api.generated.model.User;
import com.accenture.spring.api.demo_api.services.users.UserServiceImpl;

import jakarta.validation.Valid;

@Controller
public class UsersController implements UserOperationsApi {

    @Autowired
    UserServiceImpl userService;

    @Override
    public ResponseEntity<List<User>> getUsers(@Valid Boolean active) {
        List<User> users = active ? userService.getActiveUsers() : userService.getUsers();
        return users.isEmpty()? new ResponseEntity<>(users, HttpStatus.NOT_FOUND): ResponseEntity.ok(users);
    }
}
