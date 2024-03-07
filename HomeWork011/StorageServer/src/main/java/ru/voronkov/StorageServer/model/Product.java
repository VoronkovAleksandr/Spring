package ru.voronkov.StorageServer.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(schema = "products")
@Data
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id")
    private UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @Column
    @CreationTimestamp
    private LocalDateTime createDateTime;


}