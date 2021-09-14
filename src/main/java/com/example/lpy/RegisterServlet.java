package com.example.lpy;

import com.example.entity.Msg;
import com.example.service.impl.UserServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",urlPatterns = "/register.do")
public class RegisterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String username=request.getParameter("username");
       String password=request.getParameter("password");
       Msg msg=null;
       boolean check=new UserServiceImpl().register(username,password);
       if (check){
           msg=new Msg(100,"注册成功",null);
       }else{
           msg=new Msg(99,"注册失败,用户名已重复",null);
       }
       String result=new Gson().toJson(msg);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(result);
    }
}
