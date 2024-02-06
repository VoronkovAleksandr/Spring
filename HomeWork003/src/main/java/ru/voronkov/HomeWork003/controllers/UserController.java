package ru.voronkov.HomeWork003.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.voronkov.HomeWork003.models.User;
import ru.voronkov.HomeWork003.services.RegistrationService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    RegistrationService registrationService;
    @PostMapping("/add")
    public ResponseEntity<String> userAddFromParam(@RequestBody User user){
        registrationService.processRegistration(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }


}
