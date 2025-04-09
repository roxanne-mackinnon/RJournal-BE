package com.rjournal.rjournal.models;

import java.time.LocalDate;

import org.springframework.lang.NonNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NoteEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NonNull
    private String title;

    @NonNull
    private String content;

    @NonNull
    private LocalDate creationDate;


    public NoteEntity() {
        this.title = "";
        this.content = "";
        this.creationDate = LocalDate.now();
    }
    
    public NoteEntity(String title, String content, LocalDate creationDate) {
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public NoteEntity(Long id, String title, String content, LocalDate creationDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
