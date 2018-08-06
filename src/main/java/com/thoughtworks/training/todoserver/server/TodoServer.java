package com.thoughtworks.training.todoserver.server;

import com.thoughtworks.training.todoserver.model.Todo;
import com.thoughtworks.training.todoserver.model.User;
import com.thoughtworks.training.todoserver.repository.TodoRepository;
import com.thoughtworks.training.todoserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TodoServer {

    @Autowired
    TodoRepository todoRepository;
    @Autowired
    UserRepository userRepository;

    public List<Todo> find() {
        return todoRepository.findAll();
    }

    public Todo findOne(Integer id) {
        return todoRepository.findOne(id);
    }

    public void create(Todo todo) {
        todoRepository.save(todo);
    }

    public void delete(Integer id) {
        todoRepository.delete(id);
    }


    public List<Todo> list(String name) throws IOException {
        User user = userRepository.findOneByName(name);
        return todoRepository.findAllByUseridEquals(user.getId());
    }

}
