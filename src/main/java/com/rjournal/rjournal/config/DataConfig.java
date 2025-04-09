package com.rjournal.rjournal.config;

import java.time.LocalDate;
import java.time.Month;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rjournal.rjournal.models.NoteEntity;
import com.rjournal.rjournal.models.UserEntity;
import com.rjournal.rjournal.repositories.NoteRepository;
import com.rjournal.rjournal.repositories.UserRepository;

@Configuration
public class DataConfig {
    
    @Bean
    public ApplicationRunner applicationRunner(NoteRepository noteRepo, UserRepository userRepo, PasswordEncoder encoder) {
        return args -> {
            userRepo.save(new UserEntity("a@b.com", encoder.encode("123")));
            userRepo.save(new UserEntity("rdm3@williams.edu", encoder.encode("passwordasdf")));

            noteRepo.save(new NoteEntity("title", "content", LocalDate.of(2020, Month.APRIL, 1)));
            noteRepo.save(new NoteEntity("my day", "love my girlfriend!", LocalDate.of(2021, Month.JUNE, 12)));
            noteRepo.save(new NoteEntity("asdfasfdtitleasdfasdf", ";alskdfkalkjsldkjfgirlfriendsdasdf", LocalDate.of(2022, Month.OCTOBER, 31)));
        };
    }
}
