package ru.voronkov.HomeWork003.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.voronkov.HomeWork003.models.User;
import ru.voronkov.HomeWork003.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    // заполнение и вывод всех заданий
    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    // сортировка по возрасту
    @GetMapping("/sort")
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }


    // фильтр по возрасту
    @GetMapping("/filter/{age}")
    public ResponseEntity<?> filterUsersByAge(@PathVariable int age){
        return new ResponseEntity<>(service.filterUsersByAge(service.getUsers(), age), HttpStatus.OK);
    }

    // Вычисление среднего возраста
    @GetMapping("/calc")
    public ResponseEntity<?> calculateAverageAge(){
        return new ResponseEntity<>(service.calculateAverageAge(service.getUsers()), HttpStatus.OK);
    }

}