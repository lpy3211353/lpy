package com.example.lpy;

import com.example.entity.Msg;
import com.example.entity.SearchInfo;
import com.example.entity.User;
import com.example.service.impl.UserServiceImpl;
import com.example.util.SecurityUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet",urlPatterns = "/user.do")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user= (User) request.getSession().getAttribute("user");
        int type= Integer.parseInt(request.getParameter("type"));
        Msg msg = null;
        switch (type){
            case 1://修改密码
                String oldpassword=request.getParameter("oldpassword");
                String newpassword=request.getParameter("newpassword");
                if(!oldpassword.equals(user.getPassword())){
                    msg=new Msg(99,"原密码不正确！",null);
                }else{
                    new UserServiceImpl().update(user,newpassword);
                    request.getSession().invalidate();
                    msg=new Msg(100,"修改成功,请重新登录",null);
                }
                break;
            case 2://展示收藏
                List<SearchInfo> collection = new Gson().fromJson(new UserServiceImpl().myCollection(user), new TypeToken<List<SearchInfo>>() {
                }.getType());
                if (collection==null){
                    msg=new Msg(99,"暂时没有收藏哦！",null);
                }
                else if (collection.size()!=0){
                    msg=new Msg(100,"OK！",collection);
                }
                break;
            case 3://添加收藏
                int ID= Integer.parseInt(request.getParameter("ID"));
                new UserServiceImpl().addCollection(user,ID);
                msg=new Msg(100,"ok!",null);
                break;
            default:
                break;
        }
        String json=new Gson().toJson(msg);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json;charset=utf-8");
        /*返回数据*/
        response.getWriter().write(json);
    }
}
