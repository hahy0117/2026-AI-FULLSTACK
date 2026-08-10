package com.thejoa703.security;

import java.time.Instant;
import java.util.Date;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
 
//토큰 발급/검증
@Component
public class JwtProvider {
    private final JwtProperties props;  //토큰-출입증
    private final SecretKey key;   //jwt에 서명에 사용할 key
 
    //생성자
    public JwtProvider(JwtProperties props) {
        this.props = props;
        this.key = Keys.hmacShaKeyFor(props.getSecret().getBytes());  //서명용키
    }
  
    //AccessToken 생성
    public String createAccessToken(String subject, Map<String, Object> claims) {  
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(props.getAccessTokenExpSeconds());
        return Jwts.builder()
                .setIssuer(props.getIssuer())  //발급자
                .setSubject(subject)     //사용자
                .addClaims(claims)        //추가정보
                .setIssuedAt(Date.from(now))   //발급시간
                .setExpiration(Date.from(exp))  //만료시간
                .signWith(key, SignatureAlgorithm.HS256)   //HS256 알고리즘 서명
                .compact();
    }
     
    public String createRefreshToken(String subject) {   
        Instant now = Instant.now();
        Instant exp = now.plusSeconds(props.getRefreshTokenExpSeconds());   //만료시간 더 길게
        return Jwts.builder()
                .setIssuer(props.getIssuer())
                .setSubject(subject)
                .setIssuedAt(Date.from(now))
                .setExpiration(Date.from(exp))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    } 
    //토큰 파싱과 검증
    public Jws<Claims> parse(String token) {  
        return Jwts.parserBuilder()
                .setSigningKey(key)   
                .requireIssuer(props.getIssuer())   
                .build()
                .parseClaimsJws(token);
    }
}
