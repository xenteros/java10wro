package com.github.xenteros.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping("/me")
    public String loggedUserLogin() {
        return "Hello " + SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
