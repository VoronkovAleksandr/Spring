package ru.voronkov.WebClient.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.WebClient.model.api.ProductApi;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductApi productApi;



}
