package com.noteapp.Application.service.folder;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.model.Folder;
import com.noteapp.Application.repository.FolderRepository;
import com.noteapp.Application.repository.UserRepository;
import com.noteapp.Application.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {
    private final UserRepository userRepository;
    private final FolderRepository folderRepository;

    @Override
    public String createFolder(String userId,FolderCreationDto folderCreationDto) {

        var user = userRepository.getUserById(UUID.fromString(userId));

        var folder = Folder.builder()
                .name(folderCreationDto.getName())
                .isPrivate(folderCreationDto.getIsPrivate())
                .user(user)
                .build();

        folderRepository.save(folder);

        return "Folder Created";
    }

    @Override
    public String deleteFolder(UUID id) {
//        var folder = folderRepository.findFolderById(id);
//        folderRepository.delete(folder);

        folderRepository.deleteById(id);
        return "Folder Deleted";
    }

    @Override
    public String addImage(UUID id, String image) {
        var folder = folderRepository.findById(id).orElseThrow();
        var images = folder.getImages();

        if (images == null){
            images = new ArrayList<>();
        }

        images.add(image);

        folder.setImages(images);

        folderRepository.save(folder);
        return "image added";
    }

    @Override
    public String removeImage(UUID id ,String image) {
        var folder = folderRepository.findById(id).orElseThrow();
        var images = folder.getImages();

        if (images.contains(image)){
        images.remove(image);

        folder.setImages(images);
        folderRepository.save(folder);
        return "image removed";
        } else {
            return "image not available already";
        }
    }

}
