package com.noteapp.Application.controller;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.dto.note.NoteCreationDto;
import com.noteapp.Application.model.Folder;
import com.noteapp.Application.model.User;
import com.noteapp.Application.repository.UserRepository;
import com.noteapp.Application.service.folder.FolderService;
import com.noteapp.Application.service.folder.FolderServiceImpl;
import com.noteapp.Application.service.jwt.JwtService;
import com.noteapp.Application.service.note.NoteService;
import com.noteapp.Application.service.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpHeaders;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;
    private final FolderService folderService;
    private final NoteService noteService;
    private final JwtService jwtService;

    //Folder Controllers - must be signed in

    //get all public folder by all users
    @GetMapping("/folder/all")
    public List<Folder> getAllFolders() {
        return userService.getAllFolders();
    }

    //get all user's folder public/private
    @GetMapping("/folder/user")
    public List<Folder> getAllUserFolders(@RequestHeader("Authorization") String header) {
        var token = jwtService.decode(header.substring(7)).getSubject();
        final String id = token.substring(16, 52);
        log.info(token);
        log.info(id);

        return userService.findAllUserFolderByUserId(UUID.fromString(id));
    }

    //get all user's private folder
    @GetMapping("/folder/private")
    public List<Folder> getAllPrivateFolders(@RequestHeader("Authorization") String header) {
        var token = jwtService.decode(header.substring(7)).getSubject();
        final String id = token.substring(16, 52);
        log.info(token);
        log.info(id);
        return userService.findAllUserPrivateFolderByUserId(UUID.fromString(id));
    }

    @PostMapping("/folder/add")
    public String addFolder(@RequestHeader("Authorization") String header,
                            @RequestBody FolderCreationDto dto) {
        var token = jwtService.decode(header.substring(7)).getSubject();
        final String id = token.substring(16, 52);
        log.info(token);
        log.info(id);

        return folderService.createFolder(id, dto);
    }

    @DeleteMapping("/folder/delete")
    public String removeFolder(@RequestParam UUID id) {
        return folderService.deleteFolder(id);
    }

    @PostMapping("/note/add")
    public String addNote(@RequestBody NoteCreationDto noteCreationDto) {
        return noteService.addNote(noteCreationDto);
    }

    @DeleteMapping("/note/remove")
    public String removeNote(@RequestParam UUID id) {
        return noteService.removeNote(id);
    }

    @PostMapping("/folder/image/add")
    public String addImage(@RequestParam UUID id,
                           @RequestBody String image){
        return folderService.addImage(id, image);
    }

    @DeleteMapping("/folder/image/delete")
    public String removeImage(@RequestParam UUID id,
                              @RequestBody String image){
        return folderService.removeImage(id,image);
    }
}
