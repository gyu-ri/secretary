package com.nj.secretary.services.todolist.service;

import com.nj.secretary.services.todolist.domain.Todolist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodolistService {

    public void addTodo(Todolist todolist) throws Exception;

    public List<Todolist> getTodo(String userId) throws Exception;

    public int deleteTodo(int todolistId) throws Exception;

    public int doneTodo(int finishStatus) throws Exception;

}
