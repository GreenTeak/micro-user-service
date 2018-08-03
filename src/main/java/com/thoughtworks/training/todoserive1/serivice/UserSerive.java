package com.thoughtworks.training.todoserive1.serivice;


import com.thoughtworks.training.todoserive1.model.User;
import com.thoughtworks.training.todoserive1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSerive {
    @Autowired
    UserRepository userRepository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    public List<User> find() {
        return  userRepository.findAll();
    }

    public void  addUser(User user){

        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(user);
    }



    public void deleteUser(Integer id){
        userRepository.delete(id);
    }


    public boolean vertify(String name,String password){

        User user = userRepository.findOneByName(name);

        return encoder.matches(password, user.password);

    }


}
