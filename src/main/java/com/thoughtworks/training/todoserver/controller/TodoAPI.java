package com.thoughtworks.training.todoserver.controller;

import com.thoughtworks.training.todoserver.model.Todo;
import com.thoughtworks.training.todoserver.server.TodoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
public class TodoAPI {

    @Autowired
    TodoServer todolistSerive;

    @GetMapping("/todos")
    public List<Todo> todolist(Principal user) throws IOException {
        //List<Todo> list = todolistSerive.find();

        return todolistSerive.list(user.getName());
    }

    @GetMapping("/todos/{id}")
    public Todo findOne(@PathVariable Integer id) {
        return todolistSerive.findOne(id);
    }

    @PostMapping("/todos")
    public void createOne(@RequestBody Todo todo) {
        todolistSerive.create(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Integer id) {
        todolistSerive.delete(id);
    }

}
