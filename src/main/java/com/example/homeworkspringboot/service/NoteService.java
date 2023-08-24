package com.example.homeworkspringboot.service;

import com.example.homeworkspringboot.dto.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> listAll();
    Note add(Note note);
    void deleteById(long id);
    void update(Note note);
    Optional<Note> getById(long id);
}
