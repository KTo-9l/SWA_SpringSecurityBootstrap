package org.sillysociety.controllers;

import org.sillysociety.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String rootPage() {
        return "index";
    }

    @GetMapping("/unprotected/hello")
    public String welcome() {
        return "unprotectedHello";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    // To make workable PostMapping "/login", must make action="/login" in "login.html"
    // and create my own user check
    // Not high priority
//    @PostMapping("/login")
//    public String loginPost() {
//        return "redirect:/unpr/hello";
//    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout(Authentication authentication) {
        if (authentication != null) {
            authentication.setAuthenticated(false);
        }
        return "/login";
    }
}
