package ru.web.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.web.model.User;
import ru.web.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "users/index";
    }

    @GetMapping("/{id}")
    public String showUsers(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.showUsers(id));
        return "users/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/new";
        }
        userService.saveUsers(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "users/edit";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @PostMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        userService.deleteUser(id);
        model.addAttribute("userDelete", userService.showUsers(id));
        return "redirect:/users";
    }

}
