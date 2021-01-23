package com.nj.secretary.services.user.repository;

import com.nj.secretary.services.user.domain.User;

import java.util.List;
import java.util.Map;

//회원관리 CRUD 추상화/캡슐화한 DAO Interface Definition
public interface UserDAO {

    //Insert
    public void addUser(User user) throws Exception;

    //Select One : 로그인, 내정보보기
    public User getUser(String userId) throws Exception;

    //Select One : 아이디 찾기
    public User findUserId(String userName) throws Exception;

    //Select One : 비밀번호 찾기
    public User findUserPwd(String userName) throws Exception;

    //Select List
    public List<User> getUserList() throws Exception;

    //Update
    public void updateUser() throws Exception;

    //Delete
    public int deleteUser() throws Exception;

    //idCheck
    public int idCheck(String userId) throws Exception;

    //adminUser
    public List<User> getBlindedUserList();

    public List<User> getLimitedUserList();

    public List<User> getLimitDateOverUser();

    public int setLimit(Map map);

    public int releaseShareLimit(String userId);
}
