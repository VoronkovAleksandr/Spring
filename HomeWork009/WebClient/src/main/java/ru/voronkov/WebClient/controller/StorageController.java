package ru.voronkov.WebClient.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.voronkov.WebClient.model.Storage;
import ru.voronkov.WebClient.model.Product;
import ru.voronkov.WebClient.service.ProductService;
import ru.voronkov.WebClient.service.StorageService;

import java.util.UUID;

@Controller
@AllArgsConstructor
@RequestMapping("/storage")
public class StorageController {

    StorageService storageService;
    ProductService productService;

    @GetMapping
    public String getAllProductInStorage(Model model){
        model.addAttribute("storage", storageService.getProductsInStorage());
        model.addAttribute("text", "Storage");
        return "storage-list";
    }

    @PostMapping("/add")
    public String addProductToStorage(Product product, float quantity){
        storageService.addProductToStorage(product, quantity);
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
