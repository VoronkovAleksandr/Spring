package ru.voronkov.HomeWork005.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.HomeWork005.models.Task;
import ru.voronkov.HomeWork005.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {

    private final TaskService service;

    //Получаем все задачи
    @GetMapping
    public List<Task> getAllTask(){
        return service.getAllTasks();
    }


    //Добавляем новую задачу
    @PostMapping("/add")
    public Task addTask(@RequestBody Task task){
        return service.createTask(task);
    }

    //Получаем задачи со запрошенному статусу
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable Task.TaskStatus status){
        return service.getTaskByStatus(status);
    }

    //Обновляем задачу в БД
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task){
        return service.updateTask(id, task);
    }

    //Удаляем задачу
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        service.deleteTask(id);
    }
}
