package ru.voronkov.HomeWork008Task1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.voronkov.HomeWork008Task1.models.Storage;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StorageRepository extends JpaRepository<Storage, UUID> {
    @Override
    Optional<Storage> findById(UUID uuid);
}
