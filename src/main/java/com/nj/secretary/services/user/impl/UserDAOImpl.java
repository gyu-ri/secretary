package com.nj.secretary.services.user.impl;

import com.nj.secretary.services.user.domain.User;
import com.nj.secretary.services.user.repository.UserDAO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("UserDAOImpl")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addUser(User user) throws Exception {
        System.out.println("addUser UserDAOImpl start");
        sqlSession.insert("UserMapper.addUser",user);
    }

    @Override
    public User getUser(String userId) throws Exception {

        return sqlSession.selectOne("UserMapper.getUser",userId);
    }

    @Override
    public User findUserId(String userName) throws Exception {
        return sqlSession.selectOne("UserMapper.findUserId", userName);
    }

    @Override
    public int idCheck(String userId) throws Exception {
        return sqlSession.selectOne("UserMapper.idCheck",userId);
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
