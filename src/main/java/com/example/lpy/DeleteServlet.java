package com.example.lpy;

import com.example.entity.Msg;
import com.example.entity.User;
import com.example.service.impl.InfoServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "DeleteServlet",urlPatterns = "/delete.do")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Msg msg;
        User user = (User) request.getSession().getAttribute("user");
        int ID= Integer.parseInt(request.getParameter("ID"));
        if (user==null){
            msg=new Msg(99,"权限不足",null);
        }else{
            if (user.isAdmin()){
                new InfoServiceImpl().deleteInfoById(ID);
                msg=new Msg(100,"ok!",null);
            }else{
                msg=new Msg(99,"权限不足",null);
            }
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String result=new Gson().toJson(msg);
        response.getWriter().write(result);
    }
}
