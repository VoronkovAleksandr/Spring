package ru.voronkov.HomeWork005.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork005.models.Task;
import ru.voronkov.HomeWork005.repositories.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    //Получить все задачи
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    //Получить задачу по id
    public Optional<Task> getTaskById(Long id){
        return repository.findById(id);
    }

    // Создать задачу
    public Task createTask(Task task){
        return repository.save(task);
    }

    //Обновить задачу
    public Task updateTask(Long id, Task taskDetails){
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()){
            Task task = optionalTask.get();
            task.setDescription(taskDetails.getDescription());
            task.setStatus(taskDetails.getStatus());
            return repository.save(task);
        } else{
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

    //Удалить задачу
    public void deleteTask(Long id){
        repository.deleteById(id);
    }

    //Получить задачи отфильтрованные по статусу
    public List<Task> getTaskByStatus(Task.TaskStatus status) {
        return getAllTasks().stream()
                .filter(t -> t.getStatus().equals(status))
                .toList();
    }
}
