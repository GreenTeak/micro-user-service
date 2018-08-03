package com.thoughtworks.training.todoserive1.repository;

import com.thoughtworks.training.todoserive1.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findOneByName(String name);
}
