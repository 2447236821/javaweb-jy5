package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by username on 2019/8/5.
 */
@WebServlet( "/manage/user/*")
public class UsersConntroller extends HttpServlet {
    private UserService uc= new UserService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取请求路径信息
        String pathInfo=request.getPathInfo();
        String path=PathUtil.getPath(pathInfo);

        ResponseCode rs=null;
        //判断是什么请求
        switch (path){
            case "list":
               rs= listDo(request);
               break;
            case "login":
                rs=loginDo(request);
                break;
        }


            //返回响应数据
            response.getWriter().write(rs.toString());
        }
        //获取所有用户列表的请求
        private ResponseCode listDo(HttpServletRequest request){
            String pageSize= request.getParameter("pageSize");
            String pageNum=request.getParameter("pageNum");


            return uc.selectAll(pageSize,pageNum);
        }
        //用户登录
        private ResponseCode loginDo(HttpServletRequest request) {
            //获取参数
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            //调用业务层处理业务
            return uc.selectOne(username, password);
        }
    }

