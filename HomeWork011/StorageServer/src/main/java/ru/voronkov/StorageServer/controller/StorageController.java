package ru.voronkov.StorageServer.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.StorageServer.model.Storage;
import ru.voronkov.StorageServer.service.StorageService;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageController {

    StorageService storageService;

    @GetMapping
    public ResponseEntity<List<Storage>> getAllProductInStorage(){
        return ResponseEntity.ok(storageService.getProductsInStorage());
    }

    @PostMapping("/add")
    public String addProductToStorage(@RequestBody Storage storage){
        storageService.addProductToStorage(storage);
        return "redirect:/storage";
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateProductInStorage(@PathVariable UUID id,@RequestBody Storage storage){
        storageService.updateStorage(id, storage);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Storage> getProductInStorageById(@PathVariable UUID id){
        return ResponseEntity.ok(storageService.getStorageById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductFromStorage(@PathVariable UUID id){
        storageService.deleteStorage(id);
        return ResponseEntity.ok(null);
    }
}