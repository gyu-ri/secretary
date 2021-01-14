package com.nj.secretary.services.user.impl;

import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.repository.UserDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {

    @Autowired
    SqlSession sqlSession;

    @Override
    public void addUser(User user) throws Exception {
        sqlSession.insert("UserMapper.addUser",user);
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
