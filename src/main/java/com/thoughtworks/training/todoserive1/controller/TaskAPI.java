package com.thoughtworks.training.todoserive1.controller;


import com.thoughtworks.training.todoserive1.model.Task;
import com.thoughtworks.training.todoserive1.serivice.TaskSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskAPI {
    @Autowired
    TaskSerive taskSerive;

    @GetMapping("/task")
    public List<Task> taskslist(){
        return taskSerive.find();
    }

    @GetMapping("/task/{id}")
    public Task findOne(@PathVariable Integer id){
        return  taskSerive.findOne(id);
    }

    @PostMapping("/task")
    public void createOne(@RequestBody Task task){
         taskSerive.create(task);
    }
    @RequestMapping(value="/task/{id}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        taskSerive.deleteById(id);
    }


}
