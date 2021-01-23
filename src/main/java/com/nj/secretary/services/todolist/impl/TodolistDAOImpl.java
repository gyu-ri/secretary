package com.nj.secretary.services.todolist.impl;

import com.nj.secretary.services.todolist.domain.Todolist;
import com.nj.secretary.services.todolist.repository.TodolistDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("TodolistDAOImpl")
public class TodolistDAOImpl implements TodolistDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addTodolist(Todolist todolist) throws Exception {
        System.out.println("addTodolist TodolistDAOImpl start");
        sqlSession.insert("TodolistMapper.addTodolist", todolist);
    }

    @Override
    public Todolist getTodoList(String userId) throws Exception {
        return sqlSession.selectOne("TodolistMapper.getTodolist",userId);
    }

    @Override
    public void updateTodolist(String todolistId) throws Exception {
        System.out.println("updateTodolist TodolistDAOImpl start");
        sqlSession.update("TodolistMapper.updateTodolist",todolistId);
    }

    @Override
    public int deleteTodolist(String todolistId) throws Exception {
        return sqlSession.delete("TodolistMapper.deleteTodolist",todolistId);
    }

    @Override
    public boolean finishTodolist() throws Exception {
        return false;
    }
}
