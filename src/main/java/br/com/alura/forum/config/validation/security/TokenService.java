package br.com.alura.forum.config.validation.security;

import br.com.alura.forum.model.ForumUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenService {

    @Value("${forum.jwt.expiration}")
    private String expiration;
    
    @Value("${forum.jwt.secret}")
    private String secret;

    public String generateToken(Authentication authentication) {
        ForumUser user = (ForumUser) authentication.getPrincipal();
        Date now = new Date();
        Date expirationDate = new Date(now.getTime() + Long.parseLong(expiration));
        return Jwts.builder()
                .setIssuer("API Fórum Alura")
                .setSubject(user.getId().toString())
                .setIssuedAt(now)
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
                
    }

    public boolean isValidToken(String token) {
        try{
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public Long getIdFromToken(String token) {
        Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        return Long.parseLong(claims.getSubject());
    }
}
