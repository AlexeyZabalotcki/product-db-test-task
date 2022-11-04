package com.example.productdbtesttask.controller;

import com.example.productdbtesttask.data.UserData;
import com.example.productdbtesttask.exceptions.UserAlreadyExistException;
import com.example.productdbtesttask.service.RoleService;
import com.example.productdbtesttask.service.UserRoleService;
import com.example.productdbtesttask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @GetMapping
    public String register(final Model model) {
        model.addAttribute("userData", new UserData());
        return "register/register";
    }

    @PostMapping
    public String userRegistration(final @Valid UserData userData, final BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userData", userData);
            return "register/register";
        }
        try {
            userService.register(userData);
            roleService.register(userData);
            userRoleService.register(userData);
        } catch (UserAlreadyExistException ex) {
            bindingResult.rejectValue("username", "userData.username",
                    "An account already exist for this username");
            model.addAttribute("registrationForm", userData);
            return "register/register";
        }
        return "redirect:/login";
    }
}
