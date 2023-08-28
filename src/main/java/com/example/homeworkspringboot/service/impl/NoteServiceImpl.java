package com.example.homeworkspringboot.service.impl;

import com.example.homeworkspringboot.dto.Note;
import com.example.homeworkspringboot.service.NoteService;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
public class NoteServiceImpl implements NoteService {
    private Map<Long, Note> notes;

    public NoteServiceImpl() {
        notes = new HashMap<>();
    }

    @Override
    public List<Note> listAll() {
        ArrayList<Note> noteArrayList = new ArrayList<>();
        notes.forEach((aLong, note) -> noteArrayList.add(note));
        return noteArrayList;
    }

    @Override
    public void add(Note note) {
        if (getById(note.getId()).isEmpty()){
            notes.put(note.getId(), note);
        }
    }

    @Override
    public void deleteById(long id) {
        Optional<Note> note = Optional.ofNullable(notes.get(id));
        if (note.isPresent()){
            notes.remove(id);
        }
    }

    @Override
    public void update(Note note) {
        Optional<Note> notesOptional = Optional.ofNullable(notes.get(note.getId()));
        if (notesOptional.isPresent()){
            Note noteNew = notes.get(note.getId());
            noteNew.setContent(note.getContent());
            noteNew.setTitle(note.getTitle());
        }
    }

    @Override
    public Optional<Note> getById(long id) {
        return Optional.ofNullable(notes.get(id));
    }
}
