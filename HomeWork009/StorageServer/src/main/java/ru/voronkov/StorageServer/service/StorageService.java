package ru.voronkov.StorageServer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.StorageServer.model.Storage;
import ru.voronkov.StorageServer.repository.StorageRepository;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class StorageService {

    private final StorageRepository repository;

    //Добавление продукта на склад
    public void addProductToStorage(Storage storage) {
        repository.save(storage);
    }

    //Получение продуктов на складе
    public List<Storage> getProductsInStorage() {
        return repository.findAll();
    }

    //Изменение продукта на складе
    public void updateStorage(UUID id, Storage storage){
        Storage checkStorage = getStorageById(id);
        if(checkStorage != null){
            checkStorage.setQuantity(storage.getQuantity());
            repository.save(checkStorage);
        }
    }

    //Получение продукта на складе по id
    public Storage getStorageById(UUID id){
        return repository.findById(id).orElse(null);
    }

    public void deleteStorage(UUID id){
        repository.deleteById(id);
    }



}
