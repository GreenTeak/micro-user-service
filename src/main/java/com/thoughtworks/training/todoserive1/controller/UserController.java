package com.thoughtworks.training.todoserive1.controller;


import com.thoughtworks.training.todoserive1.model.User;
import com.thoughtworks.training.todoserive1.serivice.UserSerive;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class UserController{

    @Autowired
    UserSerive userSerive;

    @Value("privateKey")
    private String privateKey;

    @GetMapping("/user")
    public List<User> userList(){
        return userSerive.find();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        userSerive.addUser(user);
    }

    @DeleteMapping("/user/{id}")
    public  void deleteUser(@PathVariable Integer id){
        userSerive.deleteUser(id);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user) {

        String name =user.getName();
        System.out.println(name);
        if (userSerive.vertify(user.getName(),user.getPassword())) {

            HashMap<String, Object> claims = new HashMap<>();
            claims.put("name", user.getName());
            claims.put("password", user.getPassword());

            String token = Jwts.builder()
                    .addClaims(claims)
                    .signWith(SignatureAlgorithm.HS512, privateKey.getBytes())
                    .compact();
            return ResponseEntity.ok(token);
        }

        return ResponseEntity.ok("aaaa");
    }

}
