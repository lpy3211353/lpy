package com.example.dao.impl;

import com.example.dao.InfoDao;
import com.example.entity.*;
import com.example.util.MySQLUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InfoDaoImpl implements InfoDao {
    @Override
    public List findInfo(String msg) {
        List list=new ArrayList();
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ID,title,date FROM `msginfo` WHERE `title` LIKE ? AND is_delete=1";
        if (msg.equals("")){
            return list;
        }
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1,"%"+msg+"%");
            rs = ps.executeQuery();
            System.out.println(ps);
            while (rs.next()){
                list.add(new SearchInfo(rs.getInt("ID"),rs.getString("title"),rs.getString("date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(rs,con,ps);
        return list;
    }

    @Override
    public List findInfoById(int ID) {
        List list=new ArrayList();
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ResultInfo resultInfo=null;
        String sql="SELECT * FROM `msginfo` WHERE `ID` = ? AND is_delete=1";
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID);
            rs = ps.executeQuery();
            while (rs.next()){
                resultInfo=new ResultInfo(rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("info"),
                        rs.getString("date"),
                        rs.getInt("zan")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs==null){
            MySQLUtil.close(con,ps);
        }else{
            MySQLUtil.close(rs,con,ps);
        }
        list.add(resultInfo);

        List contentList=new ArrayList();
        sql="SELECT * FROM `content` WHERE `target` = ?";
        ContentInfo contentInfo=null;
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID);
            rs = ps.executeQuery();
            while (rs.next()){
                contentInfo =new ContentInfo(rs.getInt("ID"),
                        rs.getString("username"),
                        rs.getString("time"),
                        rs.getString("text"),
                        rs.getInt("zan")
                );
                contentList.add(contentInfo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (rs==null){
            MySQLUtil.close(con,ps);
        }else{
            MySQLUtil.close(rs,con,ps);
        }

        if (contentList.size() != 0) {
            list.add(contentList);
        }
        return list;
    }

    @Override
    public int comment(int targetID, String msg, User user) {
        Connection con = null;
        PreparedStatement ps=null;
        String sql="INSERT INTO `content`(`username`,`text`,`target`) VALUES (?,?,?)";
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2,msg);
            ps.setInt(3,targetID);
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return 0;
        }
        MySQLUtil.close(con,ps);
        return 1;
    }

    @Override
    public int deleteInfoById(int ID) {
        Connection con = null;
        PreparedStatement ps=null;
        String sql="UPDATE msginfo SET is_delete=0 WHERE `ID` = ? AND is_delete=1";
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
            MySQLUtil.close(con,ps);
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(con,ps);
        return 0;
    }

    @Override
    public List index() {
        List list=new ArrayList();
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        ResultInfo resultInfo=null;
        String sql="SELECT `ID`,`title`,`img`,`zan` FROM `msginfo` WHERE `img` IS NOT NULL and is_delete=1 ORDER BY `zan` DESC LIMIT 9 ";
        IndexInfo indexInfo;
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            rs= ps.executeQuery();
            while (rs.next()){
                indexInfo=new IndexInfo(
                        rs.getInt("ID"),
                        rs.getString("title"),
                        rs.getString("img"),
                        rs.getInt("zan")
                );
                list.add(indexInfo);
            }
        } catch (SQLException throwables) {
            MySQLUtil.close(rs,con,ps);
            throwables.printStackTrace();
        }
        MySQLUtil.close(rs,con,ps);
        return list;
    }

    @Override
    public List differentType(int type) {
        List list=new ArrayList();
        Connection con = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        String sql="SELECT ID,title,date FROM `msginfo` WHERE `kind` = ? AND is_delete=1 ORDER BY `date` DESC LIMIT 14 ";
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            switch (type){
                case 1:
                    ps.setString(1,"大赛资讯");
                    break;
                case 2:
                    ps.setString(1,"双创动态");
                    break;
                case 3:
                    ps.setString(1,"创客中心");
                    break;
                default:
                    return null;
            }
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()){
                list.add(new SearchInfo(rs.getInt("ID"),rs.getString("title"),rs.getString("date")));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(rs,con,ps);
        return list;
    }

    @Override
    public int zan(int ID) {
        Connection con = null;
        PreparedStatement ps=null;
        String sql="UPDATE msginfo SET `zan`=`zan`+1 WHERE `ID` = ?";
        try {
            con = MySQLUtil.getConnection();
            ps=con.prepareStatement(sql);
            ps.setInt(1,ID);
            ps.executeUpdate();
            MySQLUtil.close(con,ps);
            return 1;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        MySQLUtil.close(con,ps);
        return 0;
    }
}

