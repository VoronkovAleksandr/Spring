package ru.voronkov.HomeWork012.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
