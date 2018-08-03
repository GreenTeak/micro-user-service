package com.thoughtworks.training.todoserive1.repository;


import com.thoughtworks.training.todoserive1.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {

}
