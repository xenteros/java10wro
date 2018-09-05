package com.github.xenteros.controller;

import com.github.xenteros.security.UserRegistrationDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @GetMapping("/register")
    public String registerView(Model model) {
        model.addAttribute("dto", new UserRegistrationDto());
        return "register";
    }

    @GetMapping({"/login", "/users/login"})
    public String loginView() {
        return "login";
    }
}
