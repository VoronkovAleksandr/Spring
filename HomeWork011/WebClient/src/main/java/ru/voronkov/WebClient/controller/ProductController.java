package ru.voronkov.WebClient.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.WebClient.model.Product;
import ru.voronkov.WebClient.service.ProductService;

import java.util.UUID;

@Controller
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {

    private final ProductService service;

    private final Counter getRequestCounter = Metrics.counter("product_get_request_count");
    private final Counter postRequestCounter = Metrics.counter("product_post_request_count");

    //Создать товар
    @PostMapping("/add")
    public String addProduct(Product product) {
        postRequestCounter.increment();
        service.addProduct(product);
        return "redirect:/products";
    }

    @GetMapping("/add")
    public String addProductPage(Product product) {
        getRequestCounter.increment();
        return "product-add";
    }

    //Получить товар по id
    @GetMapping("/{id}")
    public String getProduct(@PathVariable UUID id, Model model) {
        model.addAttribute("product", service.getProductById(id));
        getRequestCounter.increment();
        return "product-detail";
    }

    //Получить список товаров
    @GetMapping
    public String getAllProducts(Model model) {
        getRequestCounter.increment();
        model.addAttribute("products", service.getAllProducts());
        model.addAttribute("text", "Products");
        return "product-list";
    }

    //Редактировать товар
    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable UUID id, Product product) {
        postRequestCounter.increment();
        service.updateProduct(id, product);
        return "redirect:/products";
    }

    //Удалить товар
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable UUID id) {
        getRequestCounter.increment();
        service.deleteProduct(id);
        return "redirect:/products";
    }
}
