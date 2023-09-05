package com.example.homeworkspringboot.service.impl;

import com.example.homeworkspringboot.dto.Note;
import com.example.homeworkspringboot.repository.NoteRepository;
import com.example.homeworkspringboot.service.NoteService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Data
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final NoteRepository repository;


    @Override
    public List<Note> listAll() {
        return repository.findAll();
    }

    @Override
    public void add(Note note) {
        repository.save(note);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public void update(Note note) {
        repository.save(note);
    }

    @Override
    public Optional<Note> getById(long id) {
        return repository.findById(id);
    }
}
