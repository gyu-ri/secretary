package com.nj.secretary.services.todolist.controller;

import com.nj.secretary.services.todolist.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/todolist/*")
public class TodolistController {

    @Autowired
    @Qualifier("todolistServiceImpl")
    private TodolistService todolistService;

    @GetMapping("Todolist")
    public String todolist() throws Exception{
        return "todolist/mainTodolist";
    }

}
