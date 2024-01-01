package com.noteapp.Application.controller;

import com.noteapp.Application.dto.auth.LoginDto;
import com.noteapp.Application.dto.auth.RegisterDto;
import com.noteapp.Application.service.auth.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterDto registerDto){
        return authService.register(registerDto);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginDto loginDto){
        return authService.login(loginDto);
    }
}
