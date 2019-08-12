package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.service.OrderService;
import com.itdr.utils.PathUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by username on 2019/8/11.
 */
@WebServlet(name = "OrderController",value = "/manage/order/*")
public class OrderController extends HttpServlet {
    OrderService os=new OrderService();
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
            case "send_goods":
                rs=send_goodsDo(request);
                break;
            case "search":
                rs=secrchDo(request);
                break;
            case "detail":

                rs=detailDo(request);
                break;



        }

        response.getWriter().write(rs.toString());
    }


    private ResponseCode send_goodsDo (HttpServletRequest request ) {
        ResponseCode rs= new ResponseCode();
        String  orser_no= request.getParameter("order_no");
        rs=os.send_goods(orser_no);
        return  rs;
    }

    private ResponseCode detailDo ( HttpServletRequest request ) {
        ResponseCode rs= new ResponseCode();
        String  productid= request.getParameter("order_no");

        rs= os.detail(productid);
        return rs;
    }

    private ResponseCode secrchDo ( HttpServletRequest request ) {
        ResponseCode rs= new ResponseCode();
        String  order_no= request.getParameter("order_no");

        if(order_no!=null){
            rs=os.orderSecrchid(order_no);
        }



        return rs;
    }

    private ResponseCode lisDo(HttpServletRequest request){
        ResponseCode rs=new ResponseCode();
//
        String pageSize= request.getParameter("pageSize");
        String pageNum=request.getParameter("pageNum");
        rs=os.selectAll(pageSize,pageNum);
        return rs;
    }
}
