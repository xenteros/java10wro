package com.github.xenteros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public String loggedUserLogin(Model model) {
        model.addAttribute("name", SecurityContextHolder.getContext().getAuthentication().getName());
        return "welcome";
    }

    @PutMapping
    public String register(@ModelAttribute UserRegistrationDto dto) {
        userService.register(dto);
        return "login";
    }
}
