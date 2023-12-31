package com.noteapp.Application.service.user;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.dto.note.NoteCreationDto;
import com.noteapp.Application.model.Folder;
import com.noteapp.Application.model.User;
import com.noteapp.Application.repository.FolderRepository;
import com.noteapp.Application.repository.NoteRepository;
import com.noteapp.Application.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.springframework.data.jpa.domain.Specification.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final FolderRepository folderRepository;
    private final NoteRepository noteRepository;
    private final UserRepository userRepository;


    @Override
    public List<Folder> getAllFolders() {
        return folderRepository.findAllFolders();
    }

    @Override
    public List<Folder> findAllUserFolderByUserId(UUID id) {
        return folderRepository.findAllUserFolderByUserId(id);
    }

    @Override
    public List<Folder> findAllUserPrivateFolderByUserId(UUID id) {
        return folderRepository.findAllUserPrivateFolderByUserId(id);
    }

    @Override
    public String createFolder(FolderCreationDto dto) {

//        var user = userRepository.findById(dto.getUserId());
//
//        var folder = Folder
//                .builder()
//                .user(user)
//                .name(dto.getName())
//                .isPrivate(dto.getIsPrivate())
//                .build();
//
//        folderRepository.save(folder);

        return "Folder Created";
    }
}
