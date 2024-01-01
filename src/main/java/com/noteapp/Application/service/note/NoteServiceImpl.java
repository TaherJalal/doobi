package com.noteapp.Application.service.note;

import com.noteapp.Application.dto.note.NoteCreationDto;
import com.noteapp.Application.model.Note;
import com.noteapp.Application.repository.FolderRepository;
import com.noteapp.Application.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {
    private final FolderRepository folderRepository;
    private final NoteRepository noteRepository;

    @Override
    public String addNote(NoteCreationDto note) {

        var folder = folderRepository.getFolderById(note.getFolderId());

        var newNote = Note.builder()
                .folder(folder)
                .title(note.getTitle())
                .description(note.getDescription())
                .build();

        noteRepository.save(newNote);

        return "note added";
    }

    @Override
    public String removeNote(UUID id) {
        noteRepository.deleteNoteById(id);
        return "note removed";
    }
}
