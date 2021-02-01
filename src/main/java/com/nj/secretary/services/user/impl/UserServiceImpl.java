package com.nj.secretary.services.user.impl;

import com.nj.secretary.services.user.repository.UserDAO;
import com.nj.secretary.services.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.nj.secretary.services.user.domain.User;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
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

/*    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        for (FieldError error : errors.getFieldErrors()){
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }*/

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
    public int kakaoLogin(String userId) throws Exception {
        return userDAO.kakaoLogin(userId);
    }

    @Override
    public void settingUser() throws Exception {

    }

    @Override
    public List<User> getUserList() throws Exception {
        return null;
    }

    @Override
    public void updateUser(User user) throws Exception {
    	userDAO.updateUser(user);

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
