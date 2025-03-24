package com.rjournal.rjournal.controllers;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rjournal.rjournal.models.NoteEntity;
import com.rjournal.rjournal.repositories.NoteRepository;

@RestController
@RequestMapping("/api/v1")
public class NoteController {

    private NoteRepository noteRepo;

    public NoteController(NoteRepository repo) {
        this.noteRepo = repo;
    }
    
    @GetMapping("/note/{id}")
    public NoteEntity getNote(@PathVariable("id") Long id) throws NoSuchElementException {
        return noteRepo.findById(id).orElseThrow();
    }

    @PostMapping("/note")
    public NoteEntity postNote(@Validated NoteEntity note) {
        return noteRepo.save(note);
    }

    @PutMapping("/note/{id}")
    public NoteEntity putNote(@Validated NoteEntity note) {
        return noteRepo.save(note);
    }

    @GetMapping(path = "/note/filter", params = {"searchTerm"})
    public List<NoteEntity> findBySearchTerm(@NonNull @RequestParam("searchTerm") String searchTerm) {
        return noteRepo.findByTitleContentContains(searchTerm);
    }

    @GetMapping(path = "/note/filter", params = {"startDate", "endDate"})
    public List<NoteEntity> findByDateRange(@NonNull @RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date startDate,
                                      @NonNull @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate) {
        return noteRepo.findWithinDateRange(startDate, endDate);                                    
    }
}
