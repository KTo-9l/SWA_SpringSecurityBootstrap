package org.sillysociety.controllers;

import org.sillysociety.models.swa.MyUser;
import org.sillysociety.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterPageController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public String registerPost(@ModelAttribute MyUser user) {
        if (user.getRole().isEmpty()) user.setRole("user");
        if (user.getLogin().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
            return "redirect:/register?error";
        }
        if (userService.loadUserByUsername(user.getLogin()) != null || userService.getByEmail(user.getEmail()) != null) {
            return "redirect:/register?error";
        } else {
            userService.addUser(user);
            return "redirect:/login";
        }
    }
}
