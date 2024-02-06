package ru.voronkov.HomeWork003.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.HomeWork003.models.User;
import ru.voronkov.HomeWork003.services.DataProcessingService;
import ru.voronkov.HomeWork003.services.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    RegistrationService registrationService;

    @Autowired
    DataProcessingService dataProcessingService;

    // получение всех пользователей
    @GetMapping
    public ResponseEntity<List<User>> users(){
                return new ResponseEntity<>(dataProcessingService.getUsers(), HttpStatus.OK);
    }

    // добавление пользователя
    @PostMapping("/add")
    public ResponseEntity<?> userAddFromParam(@RequestBody User user){
        registrationService.processRegistration(user);
        return new ResponseEntity<>("User added successfully", HttpStatus.CREATED);
    }



}
