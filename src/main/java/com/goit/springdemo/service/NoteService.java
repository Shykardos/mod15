package com.goit.springdemo.service;

import com.goit.springdemo.model.Note;
import com.goit.springdemo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

@Autowired
public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
        }

public List<Note> listAll() {
        return noteRepository.findAll();
        }

public Note add(Note note) {
        return noteRepository.save(note);
        }

public void deleteById(long id) {
        noteRepository.deleteById(id);
        }

public void update(Note note) {
        noteRepository.save(note);
        }

public Note getById(long id) {
        Optional<Note> optionalNote = noteRepository.findById(id);
        if (optionalNote.isEmpty()) {
        throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        return optionalNote.get();
        }
}