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
import java.util.List;

@WebServlet(name = "DynamicServlet",urlPatterns = "/dynamic.do")
public class DynamicServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Msg msg;
        int type= Integer.parseInt(request.getParameter("type"));
        List list=new InfoServiceImpl().differentType(type);
        if (list==null){
            msg=new Msg(99,"错误的参数",null);
        }else{
            msg=new Msg(100,"ok!",list);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String result=new Gson().toJson(msg);
        response.getWriter().write(result);
    }
}
