package ru.voronkov.HomeWork006.services;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.voronkov.HomeWork006.models.Note;
import ru.voronkov.HomeWork006.repositories.NoteRepository;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {

    private final NoteRepository noteRepository;

    //Получаем все заметки
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    //Добавляем новую заметку
    public Note addNote(Note note) {
        return noteRepository.save(note);
    }

    //Редактирование заметки
    public Note updateNote(Long id, Note updatedNote) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isPresent()) {
            Note note = optionalNote.get();
            note.setDescription(updatedNote.getDescription());
            note.setTitle(updatedNote.getTitle());
            return noteRepository.save(note);
        } else{
            throw new IllegalArgumentException("Note not found with id: " + id);
        }
    }
    //Поиск заметки по id
    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

    //Удаление заметки
    public void deleteNote(long id){
        noteRepository.deleteById(id);
    }
}
