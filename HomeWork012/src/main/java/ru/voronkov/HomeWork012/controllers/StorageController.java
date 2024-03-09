package ru.voronkov.HomeWork012.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.HomeWork012.models.Storage;
import ru.voronkov.HomeWork012.services.FileGateway;
import ru.voronkov.HomeWork012.services.ProductService;
import ru.voronkov.HomeWork012.services.StorageService;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageController {

    private final StorageService storageService;
    private final ProductService productService;
    private final FileGateway fileGateway;

    @GetMapping
    public String getAllProductInStorage(Model model){
        model.addAttribute("storage", storageService.getProductsInStorage());
        model.addAttribute("text", "Storage");
        return "storage-list";
    }

    @PostMapping("/add")
    public String addProductToStorage(Storage storage){
        storageService.addProductToStorage(storage);
        fileGateway.writeToFile("storage.txt", "Добавлена запись: " + storage.toString());
        return "redirect:/storage";
    }

    @GetMapping("/add")
    public String addProductInStorage(Storage storage, Model model){
        model.addAttribute("products", productService.getAllProducts());
        return "storage-add";
    }

    @PostMapping("/update/{id}")
    public String updateProductInStorage(@PathVariable UUID id, Storage storage){
        storageService.updateStorage(id, storage);
        return "redirect:/storage";
    }

    @GetMapping("/{id}")
    public String getProductInStorageById(@PathVariable UUID id, Model model){
        model.addAttribute("product", storageService.getStorageById(id));
        return "storage-product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductFromStorage(@PathVariable UUID id){
        storageService.deleteStorage(id);
        return "redirect:/storage";
    }
}
