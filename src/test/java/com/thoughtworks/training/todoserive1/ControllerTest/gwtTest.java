package com.thoughtworks.training.todoserive1.ControllerTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class gwtTest {
    @Test
    public void generateJwt(){
        Map<String, Object> claims =new HashMap<>();
        //generate
        String compact = Jwts.builder()
                .addClaims(claims)
                .setExpiration(Date.from(Instant.now().minus(1, ChronoUnit.DAYS)))
                .signWith(SignatureAlgorithm.HS512, "Kitty".getBytes())
                .compact();

        byte[] secretKey ="key".getBytes();

        //parse && verfication
        Claims body = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(compact)
                .getBody();
//        assertThat(body.get("name"),is("getian"));
//        assertThat(body.get("role"),is("dev"));
        System.out.print(compact);

    }
}
