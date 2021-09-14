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

@WebServlet(name = "CommentServlet",urlPatterns = "/comment.do")
public class CommentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Msg msg;
        if (request.getSession().getAttribute("user")==null){
            msg=new Msg(99,"未登录",null);
        }else{
            User user = (User) request.getSession().getAttribute("user");
            int ID= Integer.parseInt(request.getParameter("ID"));
            String info = request.getParameter("msg");
            new InfoServiceImpl().comment(ID,info,user);
            msg=new Msg(100,"ok",null);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String result=new Gson().toJson(msg);
        response.getWriter().write(result);
    }
}
