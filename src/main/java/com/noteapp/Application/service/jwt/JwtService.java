package com.noteapp.Application.service.jwt;

import com.noteapp.Application.dto.auth.TokenSubject;
import io.jsonwebtoken.Claims;

public interface JwtService {
    String generate(TokenSubject tokenSubject);
    Claims decode(String token);
    Boolean isExpired(String token);
}
