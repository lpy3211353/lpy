package com.example.lpy;


import com.example.entity.Msg;
import com.example.service.impl.InfoServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "IndexServlet",value = "/index.do")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Msg msg;
        List list=new InfoServiceImpl().index();
        if (list.size()==0){
            msg=new Msg(99,"error",null);
        }else{
            msg=new Msg(100,"ok!",list);
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String result=new Gson().toJson(msg);
        response.getWriter().write(result);
    }
}
