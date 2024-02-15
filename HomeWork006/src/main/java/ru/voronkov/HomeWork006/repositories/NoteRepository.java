package ru.voronkov.HomeWork006.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.voronkov.HomeWork006.models.Note;

import java.util.Optional;

public interface NoteRepository extends JpaRepository<Note, Long> {
    Optional<Note> findById(Long id);
}
