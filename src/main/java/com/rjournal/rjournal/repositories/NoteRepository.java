package com.rjournal.rjournal.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rjournal.rjournal.models.Note;

@Repository
public interface NoteRepository
    extends CrudRepository<Note, Long> {

    @Query("SELECT n FROM Note n where n.title LIKE %?1% OR n.content LIKE %?1%")
    List<Note> findByTitleContentContains(String searchTerm);
}
