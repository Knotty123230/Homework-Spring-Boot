package com.example.homeworkspringboot;

import com.example.homeworkspringboot.dto.Note;
import com.example.homeworkspringboot.service.NoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkSpringBootApplication {
    private final NoteService noteService;

    public HomeworkSpringBootApplication(NoteService noteService) {
        this.noteService = noteService;
        Note note = new Note(1L, "MyNote", "Goit is the best");
        System.out.println(
                "noteService.add(new Note(1, \"MyNote\", \"Goit is the best\")) = " +
                        noteService.add(note
                ));
        System.out.println("noteService.getById(note.getId()) = " + noteService.getById(note.getId()));
        System.out.println("noteService.listAll() = " + noteService.listAll());
        noteService.update(new Note(1L, "NewNote", "Goit"));
        System.out.println("noteService.listAll() = " + noteService.listAll());
        noteService.deleteById(1L);
        System.out.println("noteService.listAll() = " + noteService.listAll());

    }


    public static void main(String[] args) {
        SpringApplication.run(HomeworkSpringBootApplication.class, args);
    }

}
