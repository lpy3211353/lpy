package com.example.lpy;

import com.example.entity.Msg;
import com.example.service.impl.InfoServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ZanServlet",urlPatterns = "/zan.do")
public class ZanServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Msg msg;
        if (request.getSession().getAttribute("user")==null){
            msg=new Msg(99,"未登录不能点赞哦！",null);
        }else{
            int ID= Integer.parseInt(request.getParameter("ID"));
            new InfoServiceImpl().zan(ID);
            msg=new Msg(100,"点赞成功！",null);
        }
        String json=new Gson().toJson(msg);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(json);
    }
}
