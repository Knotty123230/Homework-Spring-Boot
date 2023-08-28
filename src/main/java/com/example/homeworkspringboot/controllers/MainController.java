package com.example.homeworkspringboot.controllers;

import com.example.homeworkspringboot.dto.Note;
import com.example.homeworkspringboot.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class MainController {
    private final NoteService noteService;
    @GetMapping("/test")
    public String test(){
        return "test";
    }
    @GetMapping("/list")
    public ModelAndView listAll(){
        ModelAndView modelAndView = new ModelAndView("list");
        modelAndView.addObject("notes", noteService.listAll());
        return modelAndView;
    }
    @PostMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        noteService.deleteById(id);
        return modelAndView;
    }
    @GetMapping("/edit")
    public ModelAndView edit(@RequestParam("id") Long id){
        ModelAndView modelAndView = new ModelAndView("edit");
        Optional<Note> noteOptional = noteService.getById(id);
        if (noteOptional.isPresent()) {
            Note note = noteOptional.get();
            modelAndView.addObject("note" , note);
        }
        return modelAndView;
    }
    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute("note") Note note) {
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        noteService.update(note);
        return modelAndView;
    }
    @GetMapping("/add")
    public ModelAndView getAddPage(Note note){
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", note);
        return modelAndView;
    }
    @PostMapping("/add")
    public ModelAndView add(@ModelAttribute("note") Note note){
        ModelAndView modelAndView = new ModelAndView("redirect:/list");
        noteService.add(note);
        return modelAndView;
    }
}
