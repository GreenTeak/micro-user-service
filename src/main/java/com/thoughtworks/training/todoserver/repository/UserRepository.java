package com.thoughtworks.training.todoserver.repository;

import com.thoughtworks.training.todoserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneByName(String name);

    List<User> findAllByName(String name);
}
