package com.noteapp.Application.service.folder;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.model.Folder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface FolderService {
    String createFolder(FolderCreationDto folderCreationDto);



}
