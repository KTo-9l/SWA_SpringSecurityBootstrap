package org.sillysociety.controllers;

import org.sillysociety.config.MyUserDetails;
import org.sillysociety.service.ExperimentBrigadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/protected/profile/user")
@PreAuthorize("hasAuthority('user') || hasAuthority('admin')")
public class MainUserController {
    @Autowired
    private ExperimentBrigadeService experimentBrigadeService;

    @GetMapping("")
    public String user(Model model, Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        model.addAttribute("exp_br", experimentBrigadeService.getAllExperimentBrigades());
        return "userPage";
    }
}
