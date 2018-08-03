package com.thoughtworks.training.todoserive1.serivice;

import com.thoughtworks.training.todoserive1.model.Todo;
import com.thoughtworks.training.todoserive1.model.User;
import com.thoughtworks.training.todoserive1.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class TodoSerive {

    @Autowired
    TodoRepository todoRepository;

    public List<Todo> find()throws IOException {
        //return todoRepository.list();
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

    public void changeEditStatus(Integer id){
        Todo todo = findOne(id);
        todo.setEdit(!todo.isEdit());
        todoRepository.save(todo);
    }

    public  List<Todo> list(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return todoRepository.findAllByUserIdEquals(user.getId());
    }


}
