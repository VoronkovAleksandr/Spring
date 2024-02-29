package ru.voronkov.productserver.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.productserver.model.Product;
import ru.voronkov.productserver.repository.ProductRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product getProductById(UUID id) {
        return repository.findById(id).orElse(null);
    }


    public void addProduct(Product product) {
        repository.save(product);

    }

    public void updateProduct(UUID id, Product changedProduct) {
        if (getProductById(id) != null) {
            repository.save(changedProduct);
        }
    }

    private Boolean isProduct(Product product) {
        return repository.findAll().stream().anyMatch(p -> p.equals(product));
    }

    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }
}
