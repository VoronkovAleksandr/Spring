package ru.voronkov.HomeWork012.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;


@Data
@Entity
@Table(schema = "storage")
public class Storage {

    @Id
    @GeneratedValue
    private UUID id;

    @OneToOne
    @JoinColumn(name= "fk_product_id", referencedColumnName = "product_id")
    private Product product;

    @Column(nullable = false)
    private float quantity;

}


