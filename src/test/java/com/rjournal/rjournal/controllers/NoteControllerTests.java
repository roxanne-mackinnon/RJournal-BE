package com.rjournal.rjournal.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import com.rjournal.rjournal.models.NoteEntity;
import com.rjournal.rjournal.repositories.NoteRepository;

public class NoteControllerTests {

    private NoteController noteController;

    private NoteRepository noteRepo;

    @BeforeEach
    public void setup() throws Exception {
        noteRepo = mock(NoteRepository.class);
        noteController = new NoteController(noteRepo);
    }
    
    @Test
    public void testCanAccessService() {
        Optional<NoteEntity> result = Optional.of(new NoteEntity("title","content", new Date()));
        when(noteRepo.findById(0L)).thenReturn(result);
        assertThat(noteController.getNote(0L).getTitle()).isEqualTo("title");
    }
}
