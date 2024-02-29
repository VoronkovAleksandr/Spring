package ru.voronkov.WebClient.model;


import lombok.Data;

import java.util.UUID;

@Data
public class Storage {

    private final UUID id;

    private final Product product;

    private float quantity;
}


