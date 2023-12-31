package com.noteapp.Application.service.jwt;

import com.noteapp.Application.dto.auth.TokenSubject;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtServiceImpl implements JwtService {
    private static final String SECRET = "77397A244326462948404D635166546A576E5A7234753778214125442A472D4B77397A244326462948404D635166546A576E5A7234753778214125442A472D4B";
    @Override
    public String generate(TokenSubject tokenSubject) {

        return Jwts
                .builder()
                .signWith(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET)))
//                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setSubject(String.valueOf(tokenSubject))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24 * 3))
                .compact();
    }

    @Override
    public Claims decode(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(SECRET)))
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    @Override
    public Boolean isExpired(String token) {
        return decode(token).getExpiration().before(new Date(System.currentTimeMillis()));
    }
}
