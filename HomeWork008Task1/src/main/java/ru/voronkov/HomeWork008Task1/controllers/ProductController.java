package ru.voronkov.HomeWork008Task1.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.HomeWork008Task1.models.Product;
import ru.voronkov.HomeWork008Task1.services.ProductService;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    //Создать товар
    @PostMapping("/add")
    public String addProduct(Product product){
        service.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String addProductPage(Product product){
        return "product-add";
    }

    //Получить товар по id
    @GetMapping("/{id}")
    public String getProduct(@PathVariable UUID id, Model model){
        model.addAttribute("product", service.getProductById(id));
        return "product-detail";
    }

    //Получить список товаров
    @GetMapping
    public String getAllProducts(Model model){
        model.addAttribute("products", service.getAllProducts());
        model.addAttribute("text", "Products");
        return "product-list";
    }

    //Редактировать товар
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable UUID id, Product product){
        service.updateProduct(id, product);
        return "redirect:/products";
    }

    //Удалить товар
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable UUID id){
        service.deleteProduct(id);
        return "redirect:/products";
    }
}
