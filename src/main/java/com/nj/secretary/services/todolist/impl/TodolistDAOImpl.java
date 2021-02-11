package com.nj.secretary.services.todolist.impl;

import com.nj.secretary.services.todolist.domain.Todolist;
import com.nj.secretary.services.todolist.repository.TodolistDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("TodolistDAOImpl")
public class TodolistDAOImpl implements TodolistDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addTodo(Todolist todolist) throws Exception {
        System.out.println("addTodolist TodolistDAOImpl start");
        sqlSession.insert("TodolistMapper.addTodolist", todolist);
    }

    @Override
    public List<Todolist> getTodo(String userId) throws Exception {
        return sqlSession.selectList("TodolistMapper.getTodo",userId);
    }

    @Override
    public int deleteTodo(int todolistId) throws Exception {
        return sqlSession.delete("TodolistMapper.deleteTodolist",todolistId);
    }

    @Override
    public int doneTodo(int finishStatus) throws Exception {
        return sqlSession.update("TodolistMapper.doneTodo",finishStatus);
    }

}
