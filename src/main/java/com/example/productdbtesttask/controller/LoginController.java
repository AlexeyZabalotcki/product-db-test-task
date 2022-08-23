package com.example.productdbtesttask.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String showLoginPage() {
        return "login/login";
    }

    @GetMapping("/exception")
    public String showExceptionPage() {
        return "login/exception";
    }
}
