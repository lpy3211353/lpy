package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface InfoService {
    List findInfo(String msg);
    List findInfoById(int ID);
    int comment(int targetID, String msg, User user);
    int deleteInfoById(int ID);
    List index();
    List differentType(int type);
    int zan(int ID);
}
