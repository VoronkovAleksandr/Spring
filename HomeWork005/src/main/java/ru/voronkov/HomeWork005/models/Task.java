package ru.voronkov.HomeWork005.models;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {
    public static enum TaskStatus {
        NOT_STARTED, IN_PROGRESS, COMPLETED;
    }

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String description;
    @Column
    private TaskStatus status;
    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;

}
