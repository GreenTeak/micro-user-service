
package com.thoughtworks.training.todoserive1.controller;

import com.thoughtworks.training.todoserive1.serivice.TodoSerive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class TodolistController {

    @Autowired
    TodoSerive todolistSerive;

    @GetMapping(path = "/todolist")
    public String Todolist( Model model) throws IOException {
        model.addAttribute("todos", todolistSerive.find());
        return "Hello";
    }
}
