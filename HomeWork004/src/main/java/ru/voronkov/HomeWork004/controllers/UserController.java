package ru.voronkov.HomeWork004.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.voronkov.HomeWork004.models.User;
import ru.voronkov.HomeWork004.services.UserService;


@Controller
public class UserController {
    @Autowired
    private UserService userService;


    //Возвращаем список пользователей в БД и количество
    @GetMapping("/users")
    public String findAll(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("usersCount", userService.getUsersCount());
        return "user-list";
    }

    // Вызываем форму создания User'а
    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    // Сохраняем пользователя в БД
    @PostMapping("/user-create")
    public String createUser(User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    // Вызываем форму обновления пользователя
    @GetMapping("/user-update/{id}")
    public String updateUserForm(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.getUserById(id));
        return "user-update";
    }

    // Сохраняем изменения пользователя и возвращаем список всех пользователей
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


    //Удаление пользователя
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable int id){
        userService.deleteById(id);
        return "redirect:/users";
    }

}
