package com.thoughtworks.training.todoserver.server;


import com.thoughtworks.training.todoserver.model.User;
import com.thoughtworks.training.todoserver.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSever {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public List<User> find() {
        return userRepository.findAll();
    }

    public void addUser(User user) {

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public User getUserByName(String name) {
        return userRepository.findOneByName(name);
    }

    public void deleteUser(Integer id) {
        userRepository.delete(id);
    }


    public boolean vertify(String name, String password) {

        User user = userRepository.findOneByName(name);

        return encoder.matches(password, user.password);
    }

    public User getUserByToken(String token) {
//        String name = (String) Jwts.parser()
//                .setSigningKey("privateKey".getBytes())
//                .parseClaimsJws(token)
//                .getBody().get("name");
        return userRepository.findOneByName(token);
    }
}
