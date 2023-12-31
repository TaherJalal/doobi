package com.noteapp.Application.service.auth;

import com.noteapp.Application.dto.auth.LoginDto;
import com.noteapp.Application.dto.auth.RegisterDto;

public interface AuthService {
    String register(RegisterDto registerDto);
    String login(LoginDto loginDto);
}
