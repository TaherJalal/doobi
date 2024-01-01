package com.noteapp.Application.service.folder;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.model.Folder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FolderService {
    String createFolder(String userId,FolderCreationDto folderCreationDto);
    String deleteFolder(UUID id);
    String addImage(UUID id ,String image);
    String removeImage(UUID id ,String image);
}
