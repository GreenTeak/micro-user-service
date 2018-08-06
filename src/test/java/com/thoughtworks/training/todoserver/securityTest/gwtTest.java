package com.thoughtworks.training.todoserver.securityTest;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.Test;

import java.util.HashMap;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;



public class gwtTest {
    @Test
    public void generateJwt(){

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("name","getian");
        claims.put("password","12345");
        byte[] secretKey = "kitty".getBytes();

        //generate
        String token = Jwts.builder()
                .addClaims(claims)
                .signWith(SignatureAlgorithm.HS512,"kitty".getBytes())
                .compact();

        //parse && verfication
        Claims body = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();

        assertThat(body.get("name"),is("getian"));

    }
}
