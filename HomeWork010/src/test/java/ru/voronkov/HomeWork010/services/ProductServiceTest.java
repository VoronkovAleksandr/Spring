package ru.voronkov.HomeWork010.services;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.voronkov.HomeWork010.models.Product;
import ru.voronkov.HomeWork010.repositories.ProductRepository;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
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
        testProduct.setTitle("Test_update");


        //Вызов метода
        productService.updateProduct(testProduct.getId(), testProduct);

        //Проверка
        verify(productRepository).findById(testProduct.getId());
        verify(productRepository).save(testProduct);
    }
}