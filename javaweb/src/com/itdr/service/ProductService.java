package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Product;
import com.itdr.pojo.Product_details;


import java.util.List;

/**
 * Created by username on 2019/8/11.
 */
public class ProductService {
    private ProductDao pd =new ProductDao();
    private UserDao ud =new UserDao();
    public ResponseCode selectAll( String pageSize, String pageNum ) {
        if(pageSize==null||pageSize.equals("")){
            pageSize="10";
        }
        if(pageNum==null||pageNum.equals("")){
            pageNum="1";
        }


        List<Product> li=pd.selectAll(pageSize,pageNum);
        ResponseCode rs=new ResponseCode();
        rs.setData(li);
        return  rs;
    }
    public ResponseCode selectOne ( String productName, String  productId){
        ResponseCode rs =new ResponseCode();
        if(productId==null||productId.equals("")||productName==null||productName.equals("")){
            rs.setStatus(1);
            rs.setMag("商品名称或错误");
            return rs;
        }
        Integer id=null;
        id=Integer.parseInt(productId);
        Product u= pd.selectOne(productName,id);
        if(u==null){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return  rs;
        }

        rs.setStatus(0);
        rs.setData(u);

        return rs;
    }
    public ResponseCode productSecrchid(String productid){
        ResponseCode rs=new ResponseCode();
        Integer id=null;
        id= Integer.parseInt(productid);
        Product p=pd.productSecrchid(id);
        if (p==null){
            rs.setStatus(Const.PRODUT_PARAMETER_CODE);
            rs.setMag(Const.PRODUT_PARAMETER_MSG);
        }else {
            rs.setStatus(0);
            rs.setData(p);
        }
        return rs;
    }
    public ResponseCode productSecrchName(String productname){
        ResponseCode rs=new ResponseCode();
        Product p=pd.productSecrchName(productname);
        if (p==null){
            rs.setStatus(Const.PRODUT_PARAMETER_CODE);
            rs.setMag(Const.PRODUT_PARAMETER_MSG);
        }else {
            rs.setStatus(0);
            rs.setData(p);
        }

        return rs;
    }
    public ResponseCode detail(String productid){
        ResponseCode rs=new ResponseCode();
        Integer id=null;
        id= Integer.parseInt(productid);
        Product_details p=pd.detail(id);
        if (p==null){
            rs.setStatus(Const.PRODUT_PARAMETER_CODE);
            rs.setMag(Const.PRODUT_PARAMETER_MSG);
        }else {
            rs.setStatus(0);
            rs.setData(p);
        }

        return rs;
    }


    public ResponseCode set_sale_status ( String productid, String status ) {
        ResponseCode rs=new ResponseCode();
        Integer id=null;
        id= Integer.parseInt(productid);
        Integer statu=null;
        statu= Integer.parseInt(status);
        int a=pd.set_sale_status(id,statu);
        if (a==0){
            rs.setStatus(1);
            rs.setMag("修改产品状态失败");
        }else {
            rs.setStatus(0);
            rs.setMag("修改产品状态成功");
        }

        return rs;
    }
}

