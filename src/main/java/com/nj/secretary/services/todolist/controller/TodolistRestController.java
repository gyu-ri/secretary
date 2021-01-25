package com.nj.secretary.services.todolist.controller;

import com.nj.secretary.services.todolist.domain.Todolist;
import com.nj.secretary.services.todolist.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restTodolist/*")
public class TodolistRestController {

    @Autowired
    TodolistService todolistService;

    @PostMapping("addTodolist")
    public void addTodolist(@RequestBody Todolist todolist) {
        System.out.println(todolist);

    }
}
