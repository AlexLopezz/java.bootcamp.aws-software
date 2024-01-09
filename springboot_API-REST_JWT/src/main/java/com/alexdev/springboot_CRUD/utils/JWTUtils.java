package com.alexdev.springboot_CRUD.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JWTUtils {
    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.time-expiration}")
    private String expiration;

    // Generate access token:
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+ Long.parseLong(expiration)))
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // Get method signature
    public Key getSignatureKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }
    // Valid access token
    public boolean isTokenValid(String token){
        try{
            extractAllClaims(token);
            log.info("Token valid!");
            return true;
        }catch (RuntimeException e){
            log.error("[X] Invalid token: "+ e.getMessage());
            return false;
        }
    }
    // Get all token claims
    public Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //Get username claim
    public String getUsernameClaim(String token){
        return getClaim(token, Claims::getSubject);
    }
    // Get only one claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims allClaims = extractAllClaims(token);
        return claimsTFunction.apply(allClaims);
    }

}