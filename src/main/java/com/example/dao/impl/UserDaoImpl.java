package com.example.dao.impl;


import com.example.dao.UserDao;
import com.example.entity.SearchInfo;
import com.example.entity.User;
import com.example.util.MySQLUtil;
import com.example.util.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     * @return 返回一个User对象
     */
    @Override
    public User login(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM userinfo WHERE username=? AND password=?";
        try {
            con = MySQLUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()) {
                user = new User(rs.getInt("ID"), rs.getString("username"), rs.getString("password"), rs.getInt("identify"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(rs, con, ps);
        return user;
    }

    /**
     * 注册
     *
     * @param username 用户名
     * @param password 密码
     * @return 成功返回true 失败false
     */
    @Override
    public boolean register(String username, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;
        String sql = "SELECT * FROM userinfo WHERE username=?";
        try {
            con = MySQLUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                MySQLUtil.close(rs, con, ps);
                return false;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String sql2 = "INSERT INTO `userinfo`(`username`, `password`, `identify`) VALUES (?,?,1)";
        try {
            con = MySQLUtil.getConnection();
            ps = con.prepareStatement(sql2);
            ps.setString(1, username);
            ps.setString(2, password);
            int result = ps.executeUpdate();
            if (result != 0) {
                MySQLUtil.close(con, ps);
                return true;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public int update(User user, String password) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "UPDATE `userinfo` SET `password`=? WHERE `username`=?";
        try {
            con = MySQLUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
            MySQLUtil.close(con, ps);
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(con, ps);
        return 0;
    }

    @Override
    public String myCollection(User user) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT `collection` FROM userinfo WHERE username=?";
        try {
            con = MySQLUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            while (rs.next()) {
                String json=rs.getString("collection");
                MySQLUtil.close(rs, con, ps);
                return json;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(rs, con, ps);
        return null;
    }

    @Override
    public int addCollection(User user, int ID) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT `title`,`date` FROM msginfo WHERE ID=?";
        String json = this.myCollection(user);
        System.out.println(json);
        List<SearchInfo> collection=null;
        if (json==null){
            collection = new ArrayList<>();
        }else{
            collection = new Gson().fromJson(json, new TypeToken<List<SearchInfo>>() {
            }.getType());
        }
        System.out.println(collection);
        SearchInfo searchInfo=null;
        try {
            con = MySQLUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, ID);
            rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                String date = rs.getString("date");
                searchInfo=new SearchInfo(ID,title,date);
                System.out.println(searchInfo);
                collection.add(searchInfo);
                MySQLUtil.close(rs,con,ps);
                json=new Gson().toJson(collection);
                String sql2="UPDATE `userinfo` SET `collection`=? WHERE username=?";
                con=MySQLUtil.getConnection();
                ps=con.prepareStatement(sql2);
                ps.setString(1,json);
                ps.setString(2,user.getUsername());
                ps.executeUpdate();
                return 1;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

}
