package com.rjournal.rjournal.service;

import java.util.Optional;

import org.springframework.data.util.Pair;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.rjournal.rjournal.dto.UserDto;
import com.rjournal.rjournal.models.NoteEntity;
import com.rjournal.rjournal.models.UserEntity;
import com.rjournal.rjournal.repositories.NoteRepository;

@Service
public class NoteService {

    private NoteRepository noteRepo;

    public NoteService(NoteRepository noteRepo) {
        this.noteRepo = noteRepo;
    }
    
    public Optional<NoteEntity> findByUserNoteId(@NonNull UserDto user, @NonNull Long noteId) {
        Optional<Pair<NoteEntity,UserEntity>> result = noteRepo.findByUserNoteId(user.getEmail(), noteId);
        if (result.isEmpty()) return Optional.empty();
        return Optional.of(result.get().getFirst());
    }
}
