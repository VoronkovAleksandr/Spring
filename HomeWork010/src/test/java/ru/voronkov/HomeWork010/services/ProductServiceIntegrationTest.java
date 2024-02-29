package ru.voronkov.HomeWork010.services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.voronkov.HomeWork010.models.Product;
import ru.voronkov.HomeWork010.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.verify;

@SpringBootTest
public class ProductServiceIntegrationTest {

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    @DisplayName("Проверка на вызов метода поиска по ID в репозитории")
    void getProductById() {
        // Предпосылка

        Product testProduct = new Product();
        testProduct.setId(UUID.randomUUID());
        testProduct.setTitle("test");
        testProduct.setDescription("For testing");
        testProduct.setCreateDateTime(LocalDateTime.now());
        productRepository.save(testProduct);

        //Вызов метода
        Product productAnswerService = productService.getProductById(testProduct.getId());

        //Проверка
        verify(productRepository).findById(testProduct.getId());


    }

    @Test
    @DisplayName("Проверка на вызов метода сохранения продукта в репозитории")
    void addProduct() {
        //Предпосылка
        Product testProduct = new Product();
        testProduct.setId(UUID.randomUUID());
        testProduct.setTitle("AddProductTest-title");
        testProduct.setDescription("AddProductTest-Description");
        testProduct.setCreateDateTime(LocalDateTime.now());

        //Вызов метода

        productService.addProduct(testProduct);

        //Проверка
        verify(productRepository).save(testProduct);
    }

    @Test
    @DisplayName("Проверка на вызов метода поиска продукта по ID в репозитории и сохранения продукта в репозитории")
    void updateProduct() {
        //Предпосылка
        Product testProduct = new Product();
        testProduct.setId(UUID.randomUUID());
        testProduct.setTitle("test");
        testProduct.setDescription("For testing");
        testProduct.setCreateDateTime(LocalDateTime.now());
        productRepository.save(testProduct);


        //Вызов метода
        productService.updateProduct(testProduct.getId(), testProduct);

        //Проверка
        verify(productRepository).findById(testProduct.getId());
        verify(productRepository).save(testProduct);
    }

}
