package com.nj.secretary.services.todolist.impl;

import com.nj.secretary.services.todolist.domain.Todolist;
import com.nj.secretary.services.todolist.repository.TodolistDAO;
import com.nj.secretary.services.todolist.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("todolistServiceImpl")
public class TodolistServiceImpl implements TodolistService {

    @Autowired
    @Qualifier("TodolistDAOImpl")
    private TodolistDAO todolistDAO;

    @Override
    public void addTodo(Todolist todolist) throws Exception {
        todolistDAO.addTodo(todolist);
    }

    @Override
    public List<Todolist> getTodo(String userId) throws Exception {
        return todolistDAO.getTodo(userId);
    }

    @Override
    public int deleteTodo(int todolistId) throws Exception {
        return todolistDAO.deleteTodo(todolistId);
    }


    @Override
    public int doneTodo(int todolistId) throws Exception {
        return todolistDAO.doneTodo(todolistId);
    }
}
