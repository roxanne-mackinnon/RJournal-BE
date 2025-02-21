package com.rjournal.rjournal.config;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rjournal.rjournal.models.Note;
import com.rjournal.rjournal.repositories.NoteRepository;

@Configuration
public class DataConfig {
    
    @Bean
    public ApplicationRunner applicationRunner(NoteRepository noteRepo) {
        return args -> {
            noteRepo.save(new Note("title", "content", new Date()));
            noteRepo.save(new Note("my day", "love my girlfriend!", new Date()));
            noteRepo.save(new Note("asdfasfdtitleasdfasdf", ";alskdfkalkjsldkjfgirlfriendsdasdf", new Date()));
        };
    }
}
