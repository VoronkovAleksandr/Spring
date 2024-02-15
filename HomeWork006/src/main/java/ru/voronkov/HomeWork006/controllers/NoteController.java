package ru.voronkov.HomeWork006.controllers;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.voronkov.HomeWork006.models.Note;
import ru.voronkov.HomeWork006.services.NoteService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

    private final NoteService service;

    //Добавление заметки
    @PostMapping()
    public ResponseEntity<Note> addNote(@RequestBody Note note){
        return new ResponseEntity<>(service.addNote(note), HttpStatus.CREATED);
    }

    //Просмотр всех заметок
    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes(){
        return new ResponseEntity<>(service.getAllNotes(), HttpStatus.OK);
    }

    //Получение заметки по id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getNoteById(@PathVariable Long id){
        return new ResponseEntity<>(service.getNoteById(id), HttpStatus.OK);
    }

    //Редактирование заметки
    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@PathVariable Long id, @RequestBody Note note){
        return new ResponseEntity<>(service.updateNote(id, note), HttpStatus.OK);
    }

    //Удаление заметки
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id){
        service.deleteNote(id);
        return ResponseEntity.ok().build();
    }
}
