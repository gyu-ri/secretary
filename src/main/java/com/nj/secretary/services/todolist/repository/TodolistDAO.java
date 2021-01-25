package com.nj.secretary.services.todolist.repository;

import com.nj.secretary.services.todolist.domain.Todolist;

public interface TodolistDAO {

    public void addTodolist(Todolist todolist) throws Exception;

    public Todolist getTodoList(String userId) throws Exception;

    public void updateTodolist(String todolistId) throws Exception;

    public int deleteTodolist(String todolistId) throws Exception;

    public boolean finishTodolist() throws Exception;

}
