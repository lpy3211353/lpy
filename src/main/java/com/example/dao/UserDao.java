package com.example.dao;

import com.example.entity.User;

import java.util.List;

public interface UserDao {
    /**
     * 登陆
     * @param username 用户名
     * @param password 密码
     * @return 返回一个User对象
     */
    User login(String username,String password);

    /**
     * 注册
     * @param username 用户名
     * @param password 密码
     * @return 成功返回true 失败false
     */
    boolean  register(String username,String password);

    int update(User user,String password);

    String myCollection(User user);

    int addCollection(User user,int ID);
}
