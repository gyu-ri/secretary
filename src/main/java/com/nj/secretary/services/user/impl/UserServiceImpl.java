package com.nj.secretary.services.user.impl;

import com.nj.secretary.services.user.repository.UserDAO;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.nj.secretary.services.user.domain.User;

import java.util.List;
import java.util.Map;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("UserDAOImpl")
    private UserDAO userDAO;

    //constructor
    public UserServiceImpl(){
    }

    //method
    @Override
    public void addUser(User user) throws Exception {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String userId) throws Exception {
        return userDAO.getUser(userId);
    }

    @Override
    public User findUserId(String userName) throws Exception {
        return userDAO.findUserId(userName);
    }

    @Override
    public User findUserPwd(String userName) throws Exception {
        return userDAO.findUserPwd(userName);
    }

    @Override
    public void settingUser() throws Exception {

    }

    @Override
    public List<User> getUserList() throws Exception {
        return null;
    }

    @Override
    public void updateUser() throws Exception {

    }

    @Override
    public int deleteUser() throws Exception {
        return 0;
    }

    @Override
    public int idCheck(String userId) throws Exception {
        return userDAO.idCheck(userId);
    }

    @Override
    public List<User> getBlindedUserList(){

        List<User> list = userDAO.getBlindedUserList();

        return list;
    }

    @Override
    public List<User> getLimitedUserList(){

        List<User> list = userDAO.getLimitedUserList();

        return list;
    }

    @Override
    public List<User> getLimitDateOverUser(){
        return userDAO.getLimitDateOverUser();
    }


    @Override
    public int setLimit(Map map){
        userDAO.setLimit(map);
        return 1;
    }

    @Override
    public int releaseShareLimit(String userId) {
        userDAO.releaseShareLimit(userId);
        return 1;
    }

    @Override
    public List<User> getWithdrawalReasonList() {
        return userDAO.getWithdrawalReasonList();
    }
}
