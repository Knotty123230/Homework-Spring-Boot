package com.example.homeworkspringboot.repository;

import com.example.homeworkspringboot.dto.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findAll();
    Optional<Note> findById(Long id);
}