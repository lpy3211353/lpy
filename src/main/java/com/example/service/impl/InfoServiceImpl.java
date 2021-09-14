package com.example.service.impl;

import com.example.dao.InfoDao;
import com.example.dao.impl.InfoDaoImpl;
import com.example.entity.User;
import com.example.service.InfoService;

import java.util.List;

public class InfoServiceImpl implements InfoService {
    InfoDao infoDao=new InfoDaoImpl();
    @Override
    public List findInfo(String msg) {
        return infoDao.findInfo(msg);
    }

    @Override
    public List findInfoById(int ID) {
        return infoDao.findInfoById(ID);
    }

    @Override
    public int comment(int targetID, String msg, User user) {
        return infoDao.comment(targetID, msg, user);
    }

    @Override
    public int deleteInfoById(int ID) {
        return infoDao.deleteInfoById(ID);
    }

    @Override
    public List index() {
        return infoDao.index();
    }

    @Override
    public List differentType(int type) {
        return infoDao.differentType(type);
    }

    @Override
    public int zan(int ID) {
        return infoDao.zan(ID);
    }
}
