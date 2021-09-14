package com.example.service.impl;

import com.example.dao.UserDao;
import com.example.dao.impl.UserDaoImpl;
import com.example.entity.User;
import com.example.service.UserService;

public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public boolean register(String username, String password) {
        return userDao.register(username,password);
    }

    @Override
    public int update(User user, String password) {
        return userDao.update(user,password);
    }

    @Override
    public String myCollection(User user) {
        return userDao.myCollection(user);
    }

    @Override
    public int addCollection(User user, int ID) {
        return userDao.addCollection(user,ID);
    }

}
