package com.itdr.service;

import com.itdr.common.Const;
import com.itdr.common.ResponseCode;
import com.itdr.dao.CaetgoryDao;
import com.itdr.dao.UserDao;
import com.itdr.pojo.Caetgory;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by username on 2019/8/11.
 */
public class CaetgoryService {
    private CaetgoryDao cd =new CaetgoryDao();
    private UserDao ud =new UserDao();
    public ResponseCode selectAll( String categoryId ) {
        ResponseCode rs =new ResponseCode();
        if(categoryId==null||categoryId.equals("")){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        Integer ids=null;
        try {
            ids=Integer.parseInt(categoryId);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }



        List<Caetgory> li=cd.selectAll(ids);

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
    public  ResponseCode add_category(String parentId,String categoryName){
        ResponseCode rs =new ResponseCode();
        if(parentId.equals("")||categoryName.equals("")||parentId==null||categoryName==null){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        Integer ids=null;

        try {
            ids=Integer.parseInt(parentId);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }
        Integer a= cd.add_category( ids,categoryName);
        if(a==1){
            rs.setData(a);
            rs.setMag("添加品类成功");
            rs.setStatus(0);
            return rs;
        }else {
            rs.setStatus(1);
            rs.setMag("添加品类失败");
        }


        return  rs;
    }
    public  Caetgory selectOne ( Integer id ) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());

        String sql = "select * from product where id=?";
        Caetgory u = null;
        try {
            u = qr.query(sql, new BeanHandler<Caetgory>(Caetgory.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }
   /* public  ResponseCode category_name(String parentId, String categoryName){
        ResponseCode rs =new ResponseCode();
        if(parentId.equals("")||categoryName.equals("")||parentId==null||categoryName==null){
            rs.setStatus(Const.USER_PARAMETER_CODE);
            rs.setMag(Const.USER_PARAMETER_MSG);
            return rs;
        }
        Integer ids=null;

        try {
            ids=Integer.parseInt(parentId);
        }catch (Exception e){
            rs.setStatus(105);
            rs.setMag("输入非法参数");
            return rs;
        }
        Integer a= cd. category_name( ids,categoryName);
        rs.setData(a);
        rs.setMag("更新品类名字成功");
        rs.setStatus(0);

        return  rs;
    }*/

    public ResponseCode set_category_name ( String parentid, String categoryName ) {
        Integer a=null;
        ResponseCode rs=new ResponseCode();
        try {
            a=Integer.parseInt(parentid);
        }catch (Exception e){
            rs.setStatus(1);
            rs.setMag("输入非法参数！");
            return  rs;
        }
        int b=cd.category_name(a,categoryName);
        if(b==1){
            rs.setStatus(0);
            rs.setMag("更新品类名字成功！");
            return rs;
        }else {
            rs.setStatus(1);
            rs.setMag("更新品类名字失败");
        }
        return rs;
    }
}
