package ru.voronkov.productserver.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.productserver.model.Product;
import ru.voronkov.productserver.service.ProductService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    //Создать товар
    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(Product product){
        try {
            service.addProduct(product);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    //Получить товар по id
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable UUID id){
        return ResponseEntity.ok(service.getProductById(id));
    }

    //Получить список товаров
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(service.getAllProducts());
    }

    //Редактировать товар
    @PostMapping("/update/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable UUID id, Product product){
        service.updateProduct(id, product);
        return ResponseEntity.ok(null);
    }

    //Удалить товар
    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable UUID id){
        service.deleteProduct(id);
        return ResponseEntity.ok(null);
    }
}