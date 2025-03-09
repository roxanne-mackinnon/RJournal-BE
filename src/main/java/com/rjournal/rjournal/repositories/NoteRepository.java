package com.rjournal.rjournal.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rjournal.rjournal.models.Note;

@Repository
public interface NoteRepository
    extends CrudRepository<Note, Long> {

    @Query("SELECT n FROM Note n where n.title LIKE :searchTerm OR n.content LIKE :searchTerm")
    List<Note> findByTitleContentContains(@Param("searchTerm") String searchTerm);

    @Query("SELECT n FROM Note n WHERE n.creationDate >= :startDate OR n.creationDate <= :endDate")
    List<Note> findWithinDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
