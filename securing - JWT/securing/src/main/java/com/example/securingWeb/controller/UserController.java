package com.example.securingWeb.controller;

import com.example.securingWeb.model.User;
import com.example.securingWeb.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('USER')") // Chỉ user có quyền GET
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
