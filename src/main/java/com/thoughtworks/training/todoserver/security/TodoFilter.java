package com.thoughtworks.training.todoserver.security;

import com.google.common.net.HttpHeaders;
import com.thoughtworks.training.todoserver.server.UserSever;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.thymeleaf.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

@Component
public class TodoFilter extends OncePerRequestFilter {

    @Autowired
    UserSever userSever;

    @Value("privateKey")
    private String privateKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (!StringUtils.isEmpty(token)) {
            try {
                if (validateToken(token)) {
                    String name = (String) Jwts.parser()
                            .setSigningKey(privateKey.getBytes())
                            .parseClaimsJws(token)
                            .getBody().get("name");
                    SecurityContextHolder.getContext()
                            .setAuthentication(
                                    new UsernamePasswordAuthenticationToken(name,
                                            null, Collections.emptyList()));

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
//        SecurityContextHolder.getContext()
//                .setAuthentication(new UsernamePasswordAuthenticationToken("user",null, Collections.emptyList()));
        filterChain.doFilter(request, response);
    }

    private boolean validateToken(String token) {

        Claims body = Jwts.parser()
                .setSigningKey(privateKey.getBytes())
                .parseClaimsJws(token)
                .getBody();

        String name = (String) body.get("name");
        String password = (String) body.get("password");

        return userSever.vertify(name, password);
    }

}
