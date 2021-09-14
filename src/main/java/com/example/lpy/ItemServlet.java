package com.example.lpy;

import com.example.dao.impl.InfoDaoImpl;
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

@WebServlet(name = "ItemServlet",urlPatterns = "/item.do")
public class ItemServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Msg msg=null;
        if (request.getParameter("ID").equals("")){
            msg=new Msg(0,"no",null);

        }else{
            int ID= Integer.parseInt(request.getParameter("ID"));
            List list=new InfoServiceImpl().findInfoById(ID);
            if (list.size()==0){
                msg=new Msg(99,"失败，资讯可能已被删除",null);
            }else if (list.size()==1){
                msg=new Msg(100,"OK",list);
            }else if (list.size()==2){
                msg=new Msg(200,"OK",list);
            }
        }
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        String result=new Gson().toJson(msg);
        /*返回数据*/
        response.getWriter().write(result);
    }
}
