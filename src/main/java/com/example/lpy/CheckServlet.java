package com.example.lpy;

import com.example.entity.Msg;
import com.example.entity.User;
import com.google.gson.Gson;

import javax.print.attribute.standard.MediaSize;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "CheckServlet",urlPatterns = "/check.do")
public class CheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session=request.getSession();
        Msg msg;
        if (session.getAttribute("user")==null){
            msg=new Msg(99,"未登录",null);
        }else{
            msg=new Msg(100,"已登录",session.getAttribute("user"));
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String result=new Gson().toJson(msg);
        response.getWriter().write(result);
    }
}
