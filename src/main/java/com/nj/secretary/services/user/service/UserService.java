package com.nj.secretary.services.user.service;

import com.nj.secretary.services.user.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/*
Service Layer단에서 세분화된 비즈니스로직을 처리하는 객체
 */

@Mapper
@Transactional(readOnly = true)
public interface UserService{

    @Transactional
    public void addUser(User user) throws Exception;

    //Select One
    public User getUser(String userId) throws Exception;


    public User findUserId(String userName) throws Exception;

    //Select List
    public List<User> getUserList() throws Exception;

    //Update
    public void updateUser() throws Exception;

    //Delete
    public int deleteUser() throws Exception;

    //idCheck
    public int idCheck(String userId) throws Exception;

}
