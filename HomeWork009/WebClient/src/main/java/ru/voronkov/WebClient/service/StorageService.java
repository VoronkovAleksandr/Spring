package ru.voronkov.WebClient.service;

import lombok.AllArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.voronkov.WebClient.model.Storage;
import ru.voronkov.WebClient.model.api.StorageApi;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class StorageService {

    private final StorageApi storageApi;

    //Добавление продукта на склад
    public void addProductToStorage(Storage storage) {
        RestTemplate template = new RestTemplate();
        String path = storageApi.getBasicUri() + "/add";
        template.postForEntity(path, storage, Object.class);
    }

    //Получение продуктов на складе
    public List<Storage> getProductsInStorage() {
        RestTemplate template = new RestTemplate();
        String path = storageApi.getBasicUri();
        ResponseEntity<List<Storage>> response = template.exchange(path,
                HttpMethod.GET, null,
                new ParameterizedTypeReference<List<Storage>>() {});
        return response.getBody();
    }

    //Изменение продукта на складе
    public void updateStorage(UUID id, Storage storage) {
        Storage checkStorage = getStorageById(id);
        if (checkStorage != null) {
            checkStorage.setQuantity(storage.getQuantity());
            RestTemplate template = new RestTemplate();
            String path = storageApi.getBasicUri() + "/update/" + id;
            template.postForEntity(path, storage, Object.class);
        }
    }

    //Получение продукта на складе по id
    public Storage getStorageById(UUID id) {
        RestTemplate template = new RestTemplate();
        String path = storageApi.getBasicUri() + "/{"+id+"}";
        ResponseEntity<Storage> response = template.exchange(path,
                HttpMethod.GET, null, new ParameterizedTypeReference<>() {
                });
        return response.getBody();
    }

    //Удаление товара со склада
    public void deleteStorage(UUID id) {
        RestTemplate template = new RestTemplate();
        String path = storageApi.getBasicUri() + "/update/" + id;
        template.postForEntity(path, null, Object.class);
    }

}
/**
 * //Изменение продукта на складе
 * public void updateStorage(UUID id, Storage storage){
 * Storage checkStorage = getStorageById(id);
 * if(checkStorage != null){
 * checkStorage.setQuantity(storage.getQuantity());
 * repository.save(checkStorage);
 * }
 * }
 * <p>
 * //Получение продукта на складе по id
 * public Storage getStorageById(UUID id){
 * return repository.findById(id).orElse(null);
 * }
 * <p>
 * public void deleteStorage(UUID id){
 * repository.deleteById(id);
 * }
 */