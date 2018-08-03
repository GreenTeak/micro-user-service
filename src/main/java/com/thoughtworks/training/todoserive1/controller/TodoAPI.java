package com.thoughtworks.training.todoserive1.controller;

import com.thoughtworks.training.todoserive1.model.Todo;
import com.thoughtworks.training.todoserive1.serivice.TodoSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class TodoAPI {

    @Autowired
    TodoSerive todolistSerive;

    @GetMapping("/todos")
    public List<Todo> todolist() throws IOException {
        //List<Todo> list = todolistSerive.find();
        return todolistSerive.find();
    }
    @GetMapping("/todos/{id}")
    public Todo findOne(@PathVariable Integer id){
        return  todolistSerive.findOne(id);
    }

    @PostMapping("/todos")
    public void createOne(@RequestBody Todo todo){
         todolistSerive.create(todo);
    }

    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Integer id){
        todolistSerive.delete(id);
    }
    @PutMapping("/todos/{id}")
    public void changeEditStatus(@PathVariable Integer id){
        todolistSerive.changeEditStatus(id);

    }
}
