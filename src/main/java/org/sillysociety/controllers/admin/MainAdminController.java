package org.sillysociety.controllers.admin;

import org.sillysociety.config.MyUserDetails;
import org.sillysociety.models.swa.MyUser;
import org.sillysociety.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/protected/profile/admin")
@PreAuthorize("hasAuthority('admin')")
public class MainAdminController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public String admin(Model model, Authentication authentication) {
        MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username", username);
        return "adminPages/adminPage";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "adminPages/userList";
    }

    @GetMapping("/users/edit")
    public String editUser(@RequestParam Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "adminPages/editAddPage";
    }

    @PostMapping("/users/edit")
    public String confirmEditUser(@ModelAttribute MyUser user) {
        if (userService.loadUserByUsername(user.getLogin()) != null || userService.getByEmail(user.getEmail()) != null) {
            String addAttribute = "&id=" + user.getId();
            return "redirect:/protected/profile/admin/users/edit?error" + addAttribute;
        }
        MyUser tmpUser = userService.getById(user.getId());
        if (!user.getLogin().isEmpty()) tmpUser.setLogin(user.getLogin());
        if (!user.getPassword().isEmpty()) tmpUser.setPassword(user.getPassword());
        if (!user.getEmail().isEmpty()) tmpUser.setEmail(user.getEmail());
        if (!user.getRole().isEmpty()) tmpUser.setRole(user.getRole());
        tmpUser.setDeleted(user.getDeleted());
        userService.updateUser(tmpUser);

        return "redirect:/protected/profile/admin/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        userService.safeDelete(userService.getById(id));
        return "redirect:/protected/profile/admin/users";
    }

    @GetMapping("/users/add")
    public String addPage(Model model) {
        model.addAttribute("user", new MyUser());
        System.out.println((new MyUser().getLogin()));
        System.out.println((new MyUser().getRole()));
        return "adminPages/editAddPage";
    }

    @PostMapping("/users/add")
    public String addUser(@ModelAttribute MyUser user, Model model) {
        if (user.getRole().isEmpty()) user.setRole("user");
        if (user.getLogin().isEmpty() || user.getPassword().isEmpty() || user.getEmail().isEmpty()) {
            return "redirect:/protected/profile/admin/users/add?error";
        }
        if (userService.loadUserByUsername(user.getLogin()) != null || userService.getByEmail(user.getEmail()) != null) {
            return "redirect:/protected/profile/admin/users/add?error";
        } else {
            model.addAttribute("users", userService.getAllUsers());
            userService.addUser(user);
            return "redirect:/protected/profile/admin/users";
        }
    }
}
