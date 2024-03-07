package ru.voronkov.WebClient.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

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

    private final StorageService storageService;
    private final ProductService productService;
    private final Counter getRequestCounter = Metrics.counter("storage_get_request_count");
    private final Counter postRequestCounter = Metrics.counter("storage_post_request_count");

    @GetMapping
    public String getAllProductInStorage(Model model){
        getRequestCounter.increment();
        model.addAttribute("storage", storageService.getProductsInStorage());
        model.addAttribute("text", "Storage");
        return "storage-list";
    }

    @PostMapping("/add")
    public String addProductToStorage(Product product, float quantity){
        postRequestCounter.increment();
        storageService.addProductToStorage(product, quantity);
        return "redirect:/storage";
    }

    @GetMapping("/add")
    public String addProductInStorage(Storage storage, Model model){
        getRequestCounter.increment();
        model.addAttribute("products", productService.getAllProducts());
        return "storage-add";
    }

    @PostMapping("/update/{id}")
    public String updateProductInStorage(@PathVariable UUID id, Storage storage){
        postRequestCounter.increment();
        storageService.updateStorage(id, storage);
        return "redirect:/storage";
    }

    @GetMapping("/{id}")
    public String getProductInStorageById(@PathVariable UUID id, Model model){
        getRequestCounter.increment();
        model.addAttribute("product", storageService.getStorageById(id));
        return "storage-product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProductFromStorage(@PathVariable UUID id){
        getRequestCounter.increment();
        storageService.deleteStorage(id);
        return "redirect:/storage";
    }
}
