package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.CaetgoryService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by username on 2019/8/11.
 */
@WebServlet(name = "CategoryConntroller",value = "/manage/category/*")
public class CategoryConntroller extends HttpServlet {
         CaetgoryService cs=new CaetgoryService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo=request.getPathInfo();

        String path= PathUtil.getPath(pathInfo);
        ; ResponseCode rs=null;
        switch (path){
            case "list":
                rs= lisDo(request);
                break;
            case "login":
                rs=loginDo(request);
                break;
            case "add_category":
                rs=add_category(request);
                break;
            case "set_category_name":
                rs=set_category_name(request);
                break;

        }

        response.getWriter().write(rs.toString());
    }

    private ResponseCode set_category_name ( HttpServletRequest request ) {
        ResponseCode rs=new ResponseCode();
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");
        if(user==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            return  rs;
        }


        String parentid=request.getParameter("parentId");
        String categoryName=request.getParameter("categoryName");

        return  rs=  cs.set_category_name(parentid,categoryName);

    }

    private ResponseCode add_category ( HttpServletRequest request ) {
        ResponseCode rs=new ResponseCode();
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");
        if(user==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            return  rs;
        }


        String parentid=request.getParameter("parentId");
        String categoryName=request.getParameter("categoryName");

        return  rs= cs.add_category(parentid,categoryName);

    }

    private ResponseCode lisDo(HttpServletRequest request){
        ResponseCode rs=new ResponseCode();
        HttpSession session=request.getSession();
        Users user=(Users) session.getAttribute("user");
        if(user==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            return  rs;
        }


        String categoryId=request.getParameter("categoryId");

        return  rs=  cs.selectAll(categoryId);
    }
    private ResponseCode loginDo( HttpServletRequest request){
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        ResponseCode rs= cs.selectOne(username, password);
        HttpSession session =request.getSession();
        session.setAttribute("user",rs.getData());
        return  rs;


    }
}
