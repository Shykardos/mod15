package com.goit.springdemo.service;

import com.goit.springdemo.model.Note;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoteService {
    private Map<Long, Note> noteMap = new HashMap<>();

    public List<Note> listAll() {
        return new ArrayList<>(noteMap.values());
    }

    public Note add(Note note) {
        Long id = generateUniqueId();
        note.setId(id);
        noteMap.put(id, note);
        return note;
    }

    public void deleteById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        noteMap.remove(id);
    }

    public void update(Note note) {
        Long id = note.getId();
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        noteMap.put(id, note);
    }

    public Note getById(long id) {
        if (!noteMap.containsKey(id)) {
            throw new IllegalArgumentException("Note with id " + id + " does not exist.");
        }
        return noteMap.get(id);
    }

    private Long generateUniqueId() {
        return Math.abs(java.util.UUID.randomUUID().getMostSignificantBits());
    }
}
