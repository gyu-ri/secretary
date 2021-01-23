package com.nj.secretary.services.todolist.impl;

import com.nj.secretary.services.todolist.domain.Todolist;
import com.nj.secretary.services.todolist.repository.TodolistDAO;
import com.nj.secretary.services.todolist.service.TodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("todolistServiceImpl")
public class TodolistServiceImpl implements TodolistService {

    @Autowired
    @Qualifier("TodolistDAOImpl")
    private TodolistDAO todolistDAO;

    @Override
    public void addTodolist(Todolist todolist) throws Exception {
        todolistDAO.addTodolist(todolist);
    }

    @Override
    public Todolist getTodoList(String userId) throws Exception {
        return todolistDAO.getTodoList(userId);
    }

    @Override
    public void updateTodolist(String todolistId) throws Exception {
        todolistDAO.updateTodolist(todolistId);
    }

    @Override
    public int deleteTodolist(String todolistId) throws Exception {
        return todolistDAO.deleteTodolist(todolistId);
    }

    @Override
    public boolean finishTodolist() throws Exception {
        return false;
    }
}
