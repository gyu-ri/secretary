package com.nj.secretary.services.user.repository;

import com.nj.secretary.services.user.domain.User;

import java.util.List;

//회원관리 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface UserDAO {

    //Insert
    public void addUser(User user) throws Exception;

    //Select One
    public User getUser(String userId) throws Exception;

    //Select List
    public List<User> getUserList() throws Exception;

    //Update
    public void updateUser() throws Exception;

    //Delete
    public int deleteUser() throws Exception;

    //idCheck
    public int idCheck(String userId) throws Exception;

}
