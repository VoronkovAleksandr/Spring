package ru.voronkov.HomeWork007.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {


    @GetMapping()
    public String home(Model model){
        model.addAttribute("text", "HOME PAGE");
        return "home";
    }
    @GetMapping("/user")
    public String userHome(Model model){
        model.addAttribute("text", "USER HOME PAGE");
        return "user";
    }
    @GetMapping("/admin")
    public String adminHome(Model model){
        model.addAttribute("text", "ADMIN HOME PAGE");
        return "admin";
    }

}
