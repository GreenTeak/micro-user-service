package com.thoughtworks.training.todoserive1.serivice;

import com.thoughtworks.training.todoserive1.model.Task;
import com.thoughtworks.training.todoserive1.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskSerive {
    @Autowired
    TaskRepository taskRepository;

    public List<Task> find(){
        return  taskRepository.findAll();
    }
    public Task findOne(Integer id){
        return  taskRepository.findOne(id);
    }
    public void create(Task task){
        taskRepository.save(task);
    }
    public void deleteById(Integer id){
        taskRepository.delete(id);
    }


}
