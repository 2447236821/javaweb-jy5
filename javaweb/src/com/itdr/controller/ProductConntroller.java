package com.itdr.controller;

import com.itdr.common.ResponseCode;

import com.itdr.service.ProductService;
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
@WebServlet("/manage/product/*")
public class ProductConntroller extends HttpServlet {
    private ProductService ps = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo=request.getPathInfo();
        String path= PathUtil.getPath(pathInfo);
         ResponseCode rs=null;
        switch (path){
            case "list":
                rs= lisDo(request,response);
                break;
            case "login":
                rs=loginDo(request);
                break;
            case "search":
                rs=secrchDo(request);
                break;
            case "detail":

                rs=detailDo(request);
                break;
            case "set_sale_status":
                rs=set_sale_statusDo(request);
                break;
        }

        response.getWriter().write(rs.toString());
    }

    private ResponseCode set_sale_statusDo ( HttpServletRequest request ) {
        ResponseCode rs= new ResponseCode();
        String  productid= request.getParameter("productid");
        String  status= request.getParameter("status");
        rs=ps.set_sale_status(productid,status);
        return  rs;
    }

    private ResponseCode detailDo ( HttpServletRequest request ) {
        ResponseCode rs= new ResponseCode();
        String  productid= request.getParameter("productid");

        rs= ps.detail(productid);
        return rs;
    }

    private ResponseCode secrchDo ( HttpServletRequest request ) {
        ResponseCode rs= new ResponseCode();
        String  productid= request.getParameter("productid");
        String  productname= request.getParameter("productname");
        if(productid!=null){
            rs=ps.productSecrchid(productid);
        }
        if (productname != null) {
            rs = ps.productSecrchName(productname);
        }


        return rs;
    }

    private ResponseCode lisDo(HttpServletRequest request,HttpServletResponse response){
        ResponseCode rs=new ResponseCode();


        String pageSize= request.getParameter("pageSize");
        String pageNum=request.getParameter("pageNum");
        rs=ps.selectAll(pageSize,pageNum);rs=ps.selectAll(pageSize,pageNum);
        request.setAttribute("uli",rs);
      /*  try {
            request.getRequestDispatcher("/WEB-INF/productlist.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return rs;
    }
    private ResponseCode loginDo(HttpServletRequest request){
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        ResponseCode rs= ps.selectOne(username, password);
        HttpSession session =request.getSession();
        session.setAttribute("user",rs.getData());
        return  rs;
    }

}
