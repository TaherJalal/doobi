package com.noteapp.Application.service.folder;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.model.Folder;
import com.noteapp.Application.repository.FolderRepository;
import com.noteapp.Application.repository.UserRepository;
import com.noteapp.Application.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService{
    private final UserRepository userRepository;
    private final FolderRepository  folderRepository;
    @Override
    public String createFolder(FolderCreationDto folderCreationDto) {
//        var folder = Folder.builder()
//                .name(folderCreationDto.getName())
//                .
        return null;
    }

    public List<Folder> findAllUserFolderByUserId(UUID id) {
        return folderRepository.findAllUserFolderByUserId(id);
    }
}
