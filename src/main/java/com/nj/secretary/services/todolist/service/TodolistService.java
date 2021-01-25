package com.nj.secretary.services.todolist.service;

import com.nj.secretary.services.todolist.domain.Todolist;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TodolistService {

    public void addTodolist(Todolist todolist) throws Exception;

    public Todolist getTodoList(String userId) throws Exception;

    public void updateTodolist(String todolistId) throws Exception;

    public int deleteTodolist(String todolistId) throws Exception;

    public boolean finishTodolist() throws Exception;

}
