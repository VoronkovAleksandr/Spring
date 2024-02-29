package ru.voronkov.WebClient.service;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.voronkov.WebClient.model.Product;
import ru.voronkov.WebClient.model.api.ProductApi;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductApi productApi;

    public List<Product> getAllProducts() {
        RestTemplate template = new RestTemplate();
        String path = productApi.getBasicUri();
        ResponseEntity<List<Product>> response = template.exchange(path,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Product>>() {
                });
        return response.getBody();
    }

    public Product getProductById(UUID id) {
        RestTemplate template = new RestTemplate();
        String path = productApi.getBasicUri() + "/" + id ;
        ResponseEntity<Product> response = template.exchange(path,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return response.getBody();
    }

    public void addProduct(Product product) {
        String path = productApi.getBasicUri() + "/add";
        RestTemplate template = new RestTemplate();
        template.postForEntity(path, product, Product.class);
    }

    public void updateProduct(UUID id, Product changedProduct) {
        Product checkProduct = getProductById(id);
        if (checkProduct != null) {
            checkProduct.setTitle(changedProduct.getTitle());
            checkProduct.setDescription(changedProduct.getDescription());
            RestTemplate template = new RestTemplate();
            String path = productApi.getBasicUri() + "/update/" + id;
            template.postForEntity(path, checkProduct, Object.class);
        }
    }

    public void deleteProduct(UUID id) {
        RestTemplate template = new RestTemplate();
        String path = productApi.getBasicUri() + "/delete/" + id;
        template.delete(path);
    }
}
