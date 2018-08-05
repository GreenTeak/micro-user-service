package com.thoughtworks.training.todoserive1.serivice;

import com.thoughtworks.training.todoserive1.model.Todo;
import com.thoughtworks.training.todoserive1.model.User;
import com.thoughtworks.training.todoserive1.repository.TodoRepository;
import com.thoughtworks.training.todoserive1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TodoSerive {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UserRepository userRepository;

    public List<Todo> find()throws IOException {
        return  todoRepository.findAll();
    }

    public Todo findOne(Integer id){
        return todoRepository.findOne(id);
    }

    public void create(Todo todo){
        todoRepository.save(todo);
    }

    public void delete(Integer id){
        todoRepository.delete(id);
    }


    public  List<Todo> list(String name) throws IOException{

         //User user = userRepository.findOneByName(name);
         User user = userRepository.findOneByName(name);
        return todoRepository.findAllByUseridEquals(user.getId());
    }

}
