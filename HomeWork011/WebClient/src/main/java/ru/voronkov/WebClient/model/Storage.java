package ru.voronkov.WebClient.model;


import lombok.Data;

import java.util.UUID;

@Data
public class Storage {

    private UUID id;

    private Product product;

    private float quantity;
}


