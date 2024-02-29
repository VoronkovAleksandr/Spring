package ru.voronkov.HomeWork010.services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork010.aspect.TimeExecute;
import ru.voronkov.HomeWork010.aspect.TrackUserAction;
import ru.voronkov.HomeWork010.models.Product;
import ru.voronkov.HomeWork010.repositories.ProductRepository;

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


    @TrackUserAction
    public void addProduct(Product product) {
        repository.save(product);

    }

    @TimeExecute
    public void updateProduct(UUID id, Product changedProduct) {
        if (getProductById(id) != null) {
            repository.save(changedProduct);
        }
    }

    private Boolean isProduct(Product product) {
        return repository.findAll().stream().anyMatch(p -> p.equals(product));
    }

    @TrackUserAction
    public void deleteProduct(UUID id) {
        repository.deleteById(id);
    }
}
