package com.noteapp.Application.controller;

import com.noteapp.Application.dto.folder.FolderCreationDto;
import com.noteapp.Application.model.Folder;
import com.noteapp.Application.model.User;
import com.noteapp.Application.repository.UserRepository;
import com.noteapp.Application.service.folder.FolderService;
import com.noteapp.Application.service.folder.FolderServiceImpl;
import com.noteapp.Application.service.jwt.JwtService;
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
public class UserController {

    private final UserService userService;
    private final JwtService jwtService;

    //Folder Controllers

    //get all public folder by all users
    @GetMapping("/folder")
    public List<Folder> getAllFolders(){
        return userService.getAllFolders();
    }

    //get all user's folder public/private
    @GetMapping("/folder/user")
    public List<Folder> getAllUserFolders(@RequestHeader("Authorization") String header){
        var token = jwtService.decode(header.substring(7)).getSubject();
        final String id = token.substring(16,52);
        return userService.findAllUserFolderByUserId(UUID.fromString(id));
    }

    //get all user's private folder
    @GetMapping("/folder/private")
    public List<Folder> getAllPrivateFolders(@RequestHeader("Authorization") String header){
        var token = jwtService.decode(header.substring(7)).getSubject();
        final String id = token.substring(16,52);
        return userService.findAllUserPrivateFolderByUserId(UUID.fromString(id));
    }

}
