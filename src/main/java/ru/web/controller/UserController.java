package ru.web.controller;

import org.springframework.data.repository.query.Param;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import ru.web.model.User;
import ru.web.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        return "index";
    }

    @GetMapping("/show")
    public String showUsers(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.showUsers(id));
        return "show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/new";
        }
        userService.saveUsers(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.updateUser(id, user);
        return "edit";
    }

    @PostMapping("/edit")
    public String updateUser(@ModelAttribute("user") User user, @Param("id") Integer id) {
        userService.updateUser(id, user);
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}
