package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Users;

import java.util.List;

/**
 * Created by username on 2019/8/5.
 */
public class UserService {
     private UserDao ud=new UserDao();
    public ResponseCode selectAll(String pageSize, String pageNum){
        if (pageSize==null || pageSize.equals("")){
            pageSize="10";
        }
        if (pageNum==null || pageSize.equals("")){
            pageNum="1";
        }

        List<Users> li=ud.selectAll(pageSize,pageNum);
        //如果集合元素为空？
        ResponseCode rs=new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
        //用户登陆
    public ResponseCode selectOne(String username, String password) {
        ResponseCode rs=new ResponseCode();
        if (username==null || username.equals("") || password==null || password.equals("")){
            rs.setData(1);
            rs.setMag("账号或密码错误");
            return rs;
        }
        //查找是否有这样一个用户
        Users u=ud.selestOne(username,password);
        //如果用户不存在
        if(u==null){
            rs.setData(1);
            rs.setMag("账号或密码错误");
            return rs;
        }

        //用户权限
        if(u.getType()!=1){
            rs.setData(2);
            rs.setMag("没有操作权限");
            return rs;
        }
        rs.setStatus(0);
        rs.setData(u);
        return rs;
    }
}
