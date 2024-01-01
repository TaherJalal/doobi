package com.noteapp.Application.repository;

import com.noteapp.Application.model.Note;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NoteRepository extends JpaRepository<Note, UUID> {
    @Modifying
    @Transactional
    @Query("DELETE from Note n WHERE n.id= :id")
    void deleteNoteById(UUID id);
}
