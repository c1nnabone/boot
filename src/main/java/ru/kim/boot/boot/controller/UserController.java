package ru.kim.boot.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kim.boot.boot.entity.User;
import ru.kim.boot.boot.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getUsers(ModelMap model) {
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String add(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String getEditableUser(@RequestParam(value = "id") Long id, Model model) {
        model.addAttribute("usertoupdate", userService.getUserById(id));
        return "edit";
    }

    @PatchMapping("/edit")
    public String editUser(@ModelAttribute("usertoupdate") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") Long id) {
        userService.removeById(id);
        return "redirect:/users";
    }
}
