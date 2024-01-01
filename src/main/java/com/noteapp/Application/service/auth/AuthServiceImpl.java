package com.noteapp.Application.service.auth;

import com.noteapp.Application.dto.auth.LoginDto;
import com.noteapp.Application.dto.auth.RegisterDto;
import com.noteapp.Application.dto.auth.TokenSubject;
import com.noteapp.Application.model.Role;
import com.noteapp.Application.model.User;
import com.noteapp.Application.repository.UserRepository;
import com.noteapp.Application.service.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final BCryptPasswordEncoder passwordEncoder;
    private final AuthenticationManager authManager;

    @Override
    public String register(RegisterDto registerDto){

//        if (!registerDto.getEmail().contains("@") || !registerDto.getEmail().contains(".")){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"not a valid email address");
//        }
//
//        if (!registerDto.getPassword().contains("@") || !registerDto.getPassword().contains(".")){
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"weak password");
//        }



        var user = User.builder()
                .firstName(registerDto.getFirstName())
                .lastName(registerDto.getLastName())
                .email(registerDto.getEmail())
                .role(Role.USER)
                .pass(passwordEncoder.encode(registerDto.getPassword()))
                .build();

        userRepository.save(user);

        var subject = TokenSubject
                .builder()
                .id(user.getId().toString())
                .email(user.getEmail())
                        .build();



        return jwtService.generate(subject);
    }

    @Override
    public String login(LoginDto loginDto) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword()));

        var user = userRepository.getUserByEmail(loginDto.getEmail()).orElseThrow();

        var subject = TokenSubject
                .builder()
                .id(user.getId().toString())
                .email(user.getEmail())
                .build();

        return jwtService.generate(subject);
    }
}

