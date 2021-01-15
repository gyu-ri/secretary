package com.nj.secretary.services.user.impl;

import com.nj.secretary.services.user.repository.UserDAO;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.nj.secretary.services.user.domain.User;

import java.util.List;

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
        return null;
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
}
