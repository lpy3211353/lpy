package com.example.service;

import com.example.entity.User;

public interface UserService {
    User login(String username,String password);
    boolean register(String username,String password);
    int update(User user,String password);
    String myCollection(User user);
    int addCollection(User user,int ID);
}
