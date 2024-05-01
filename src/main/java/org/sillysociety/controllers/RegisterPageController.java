package org.sillysociety.controllers;

import org.sillysociety.models.swa.MyUser;
import org.sillysociety.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterPageController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public String registerPost(
            @RequestParam String login, @RequestParam String pass, @RequestParam String email) {
        if (userService.loadUserByUsername(login) != null || userService.getByEmail(email) != null) {
            return "redirect:/register?error";
        } else {
            MyUser newUser = new MyUser();
            newUser.setLogin(login);
            newUser.setPassword(pass);
            newUser.setEmail(email);
            userService.addUser(newUser);
            return "redirect:/login";
        }
    }
}
