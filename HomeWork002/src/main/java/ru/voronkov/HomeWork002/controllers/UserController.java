package ru.voronkov.HomeWork002.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.HomeWork002.models.User;
import ru.voronkov.HomeWork002.services.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userService.findAll();

        model.addAttribute("users", users);
        return "user-list";
        //return "home.html";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(@RequestParam int id, String firstName, String lastName){
        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        System.out.println(user);
        userService.updateUser(user);
        return "redirect:/users";
    }



    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

}