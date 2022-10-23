package com.itsse.backend.security;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.itsse.backend.entity.UserEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenProvider {
    //
    // TODO. SECRET KEY를 생성자에서 Token Provider가 생성될때 만들어야 하는건지?
    private static final String SECRET_KEY = "eyJzdWIiOiJGSVJTVFNFQ1JFVE6MjAyMjEwMjMxMjE3MDB9";
    
    public String create(UserEntity userEntity) {
        // 기한은 지금부터 1일로 설정
        Date expiryDate = Date.from(Instant.now().plus(1, ChronoUnit.DAYS));
        String userUid = Long.toString(userEntity.getIds());
        
        /* 
         * TODO.
         * https://mia-dahae.tistory.com/121
         * 위 레퍼런스 참조하여 key 붙여서 생성기 만들기
         * */
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .setSubject(userUid)
                .setIssuer("itsse_com")
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .compact();
    }
    
    public String validateAndGetUserId(String token) {
        /*
         * 동작방식
         * 1. parseClaimsJws 메서드가 Base64로 디코딩 및 파싱
         * 2. 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용해 서명한 후 token의 서명과 비교
         * 3. 위조되지 않았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림.
         * 4. 그중 우리는 userId가 필요하므로 getBody를 부른다.
         */
        Claims claims = Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
        
        return claims.getSubject();
        
    }
}
