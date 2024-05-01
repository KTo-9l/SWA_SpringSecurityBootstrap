package org.sillysociety.controllers;

import org.sillysociety.config.MyUserDetails;
import org.sillysociety.models.swa.MyUser;
import org.sillysociety.service.ExperimentBrigadeService;
import org.sillysociety.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/protected")
public class ProtectedController {
    @Autowired
    private UserService userService;
    @Autowired
    private ExperimentBrigadeService experimentBrigadeService;

    @GetMapping("/profile")
    public String profile(Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();

        if (role.equals("admin")) {
            return "redirect:/protected/profile/admin";
        } else {
            return "redirect:/protected/profile/user";
        }
    }
}
