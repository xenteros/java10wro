package com.github.xenteros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@Controller
class TokenController {

    private TokenService tokenService;

    @Autowired
    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @GetMapping("/passwords/reset/{username}")
    public String getResetPasswordView(Model model, @PathVariable String username) {
        String token = tokenService.createToken(username);
        model.addAttribute("token", token);
        model.addAttribute("dto", new ResetPasswordDto());
        return "reset-password";
    }

    @PutMapping("/passwords/reset")
    public String resetPassword(Model model, @ModelAttribute ResetPasswordDto dto) {
        if (!dto.getPassword().equals(dto.getRepeatPassword())) {
            model.addAttribute("token", dto.getToken());
            model.addAttribute("dto", new ResetPasswordDto());
            return "reset-password";
        }
        tokenService.resetPassword(dto.getToken(), dto.getPassword());
        return "login";
    }
}
