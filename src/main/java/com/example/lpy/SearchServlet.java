package com.example.lpy;

import com.example.entity.Msg;
import com.example.service.impl.InfoServiceImpl;
import com.google.gson.Gson;

import javax.naming.directory.SearchResult;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet",urlPatterns = "/search.do")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchMsg=request.getParameter("msg");
        List searchResult=new InfoServiceImpl().findInfo(searchMsg);
        Msg msg=null;
        if (searchResult.size()==0){
            msg=new Msg(99,"暂无结果",null);
        }else{
            msg=new Msg(100,"搜索成功",searchResult);
        }
        String result=new Gson().toJson(msg);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(result);
    }
}
