package com.luppi.gestaofinanceira.security;

import com.luppi.gestaofinanceira.entity.OfficeEntity;
import com.luppi.gestaofinanceira.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TokenService {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private String expiration;

    private static final String KEY_ROLES = "roles";

    public String generateToken(UserEntity usuarioEntity) {

        Date now = new Date();
        Date exp = new Date(now.getTime() + Long.parseLong(expiration));

        List<String> listCargos = usuarioEntity.getOffices()
                .stream()
                .map(OfficeEntity::getName)
                .toList();

        String token = Jwts.builder()
                .setIssuer("dbccompras-api")
                .claim(Claims.ID, usuarioEntity.getIdUser())
                .claim(KEY_ROLES, listCargos)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();

        return TokenAuthenticationFilter.BEARER + token;
    }

    public UsernamePasswordAuthenticationToken isValid(String token) {
        if(token == null) {
            return null;
        }

        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        Integer idUsuario = body.get(Claims.ID, Integer.class);

        if(idUsuario != null) {
            List<String> roles = body.get(KEY_ROLES, List.class);

            List<SimpleGrantedAuthority> officeAuthority = roles.stream()
                    .map(SimpleGrantedAuthority::new).toList();

            return new UsernamePasswordAuthenticationToken(idUsuario, null, officeAuthority);
        }
        return null;
    }
}
