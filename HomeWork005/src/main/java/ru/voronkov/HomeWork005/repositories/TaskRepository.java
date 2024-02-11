package ru.voronkov.HomeWork005.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.voronkov.HomeWork005.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {

}
