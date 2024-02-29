package ru.voronkov.WebClient.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;


@Data
public class Product {

    private final UUID id;

    private String title;

    private String description;

    private final LocalDateTime createDateTime;


}
