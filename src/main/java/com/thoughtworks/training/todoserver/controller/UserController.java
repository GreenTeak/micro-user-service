package com.thoughtworks.training.todoserver.controller;


import com.thoughtworks.training.todoserver.model.User;
import com.thoughtworks.training.todoserver.server.UserSever;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserSever userSever;

    @Value("privateKey")
    private String privateKey;

    @GetMapping("/users")
    public List<User> userList() {
        return userSever.find();
    }

    @PostMapping("/verifications")
    public User verifyToken(@RequestBody String name){
        return userSever.getUserByToken(name);
    }

    @PostMapping("/users")
    public void addUser(@RequestBody User user) {

        userSever.addUser(user);

    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Integer id) {
        userSever.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {

        System.out.println(user.getName());

        if (userSever.vertify(user.getName(), user.getPassword())) {

            HashMap<String, Object> claims = new HashMap<>();

            User user1 = userSever.getUserByName(user.getName());

            claims.put("id", user1.getId());
            claims.put("name", user1.getName());

            String token = Jwts.builder()
                    .addClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, privateKey.getBytes())
                    .compact();

            System.out.println(token);
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.ok("aaaa");
    }

}
