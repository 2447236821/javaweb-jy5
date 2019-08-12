package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Orders;
import com.itdr.pojo.Users;

import java.util.List;

/**
 * Created by username on 2019/8/11.
 */
public class OrderService {
    private OrderDao pd =new OrderDao();
    private UserDao ud =new UserDao();
    public ResponseCode selectAll(String pageSize, String pageNum ) {
        ResponseCode rs=new ResponseCode();
        if(pageSize==null||pageSize.equals("")){
            pageSize="10";
        }
        if(pageNum==null||pageNum.equals("")){
            pageNum="1";
        }


        List<Orders> li=pd.selectAll(pageSize,pageNum);

        rs.setData(li);
        return  rs;
    }
    public ResponseCode selectOne ( String username, String password ){
        ResponseCode rs =new ResponseCode();
        if(username==null||username.equals("")||password==null||password.equals("")){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        Users u= ud.selectOne(username,password);
        if(u==null){
            rs.setStatus(1);
            rs.setMag("账号或密码错误");
            return  rs;
        }

        rs.setStatus(0);
        rs.setData(u);

        return rs;
    }
    public ResponseCode orderSecrchid(String productid){
        ResponseCode rs=new ResponseCode();
        Integer id=null;
        id= Integer.parseInt(productid);
        Orders p=pd.orderSecrchid(id);
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
        Long id=null;
        id= Long.parseLong(productid);
        Orders p=pd.detail(id);
        if (p==null){
            rs.setStatus(Const.PRODUT_PARAMETER_CODE);
            rs.setMag(Const.PRODUT_PARAMETER_MSG);
        }else {
            rs.setStatus(0);
            rs.setData(p);
        }

        return rs;
    }


    public ResponseCode send_goods ( String order_no ) {
        ResponseCode rs = new ResponseCode();
        Long id = null;
        id = Long.parseLong(order_no);

        int a = pd.send_goods(id);
        if (a == 0) {
            rs.setStatus(1);
            rs.setMag("修改产品状态失败");
        } else {
            rs.setStatus(0);
            rs.setMag("发货成功");
        }

        return rs;
    }
}
