package com.noteapp.Application.service.user;

//import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.dto.note.NoteCreationDto;
import com.noteapp.Application.model.Folder;
import com.noteapp.Application.model.Note;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;
//import com.noteapp.Application.model.Note;

public interface UserService {

    List<Folder> getAllFolders();

    List<Folder> findAllUserFolderByUserId(UUID id);

    List<Folder> findAllUserPrivateFolderByUserId(UUID id);
//
//    List<Folder> getUserPrivateFoldersByUserId(@Param("id") UUID id);
    String createFolder(FolderCreationDto dto);
//    String deleteFolder(UUID id);
//    String createNote(NoteCreationDto dto);
//    String addImage(String image);
//    String addListOfImages(List<String> images);
}
