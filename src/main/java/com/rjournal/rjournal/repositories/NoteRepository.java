package com.rjournal.rjournal.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Repository;

import com.rjournal.rjournal.models.NoteEntity;
import com.rjournal.rjournal.models.UserEntity;

@Repository
public interface NoteRepository
    extends CrudRepository<NoteEntity, Long> {

    @Query("SELECT new org.springframework.data.util.Pair(note,user) FROM NoteEntity note, UserEntity user WHERE note.id = :noteId AND user.email = :userEmail")
    Optional<Pair<NoteEntity,UserEntity>> findByUserNoteId(@Param("userEmail") String userEmail, @Param("noteId") Long noteId);

    @Query("SELECT n FROM NoteEntity n where n.title LIKE :searchTerm OR n.content LIKE :searchTerm")
    List<NoteEntity> findByTitleContentContains(@Param("searchTerm") String searchTerm);

    @Query("SELECT n FROM NoteEntity n WHERE n.creationDate >= :startDate OR n.creationDate <= :endDate")
    List<NoteEntity> findWithinDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
