package com.example.lpy;

import com.example.entity.Msg;
import com.example.entity.User;
import com.example.service.UserService;
import com.example.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        HttpSession session= request.getSession();
        Msg msg=null;
        User user=null;
        user=new UserServiceImpl().login(username,password);
        if (user==null){
            msg=new Msg(99,"账号或密码错误",null);
        }else{
            session.setAttribute("user",user);
            msg=new Msg(100,"登录成功",user);
        }
        String json=new Gson().toJson(msg);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(json);
    }
}
