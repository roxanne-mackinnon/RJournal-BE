package com.rjournal.rjournal.config;

import java.util.Date;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rjournal.rjournal.models.NoteEntity;
import com.rjournal.rjournal.models.UserEntity;
import com.rjournal.rjournal.repositories.NoteRepository;
import com.rjournal.rjournal.repositories.UserRepository;

@Configuration
public class DataConfig {
    
    @Bean
    public ApplicationRunner applicationRunner(NoteRepository noteRepo, UserRepository userRepo) {
        return args -> {
            userRepo.save(new UserEntity("a@b.com", "123"));
            userRepo.save(new UserEntity("rdm3@williams.edu", "passwordasdf"));

            noteRepo.save(new NoteEntity("title", "content", new Date()));
            noteRepo.save(new NoteEntity("my day", "love my girlfriend!", new Date()));
            noteRepo.save(new NoteEntity("asdfasfdtitleasdfasdf", ";alskdfkalkjsldkjfgirlfriendsdasdf", new Date()));
        };
    }
}
