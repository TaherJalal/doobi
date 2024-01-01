package com.noteapp.Application.service.note;

import com.noteapp.Application.dto.note.NoteCreationDto;

import java.util.UUID;

public interface NoteService {
    String addNote(NoteCreationDto note);
    String removeNote(UUID id);
}
