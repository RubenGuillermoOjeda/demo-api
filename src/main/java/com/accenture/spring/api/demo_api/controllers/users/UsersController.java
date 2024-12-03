package com.accenture.spring.api.demo_api.controllers.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.accenture.spring.api.demo_api.generated.controller.UserOperationsApi;
import com.accenture.spring.api.demo_api.generated.model.User;
import com.accenture.spring.api.demo_api.services.users.IUSerService;

import jakarta.validation.Valid;

@Controller
public class UsersController implements UserOperationsApi {

    @Autowired
    IUSerService userService;

    @Override
    public ResponseEntity<List<User>> getUsers(@Valid Boolean active) {
        List<User> users = active ? userService.getActiveUsers() : userService.getUsers();
        return ResponseEntity.ok(users);
    }
}
