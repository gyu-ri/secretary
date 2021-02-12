package com.nj.secretary.services.todolist.repository;

import com.nj.secretary.services.todolist.domain.Todolist;

import java.util.List;

public interface TodolistDAO {

    public void addTodo(Todolist todolist) throws Exception;

    public List<Todolist> getTodo(String userId) throws Exception;

    public int deleteTodo(int todolistId) throws Exception;

    public int doneTodo(int todolistId) throws Exception;

}
