package com.itdr.dao;
import com.itdr.pojo.Users;
import com.itdr.utils.PoolUtil;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by username on 2019/8/5.
 */
public class UserDao {
    public List<Users> selectAll(String pageSize, String pageNum) {
       // ComboPooledDataSource co= PoolUtil.getCom();
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql="select * from users limit ?,?";
        List<Users> li=null;
        try{
            li=qr.query(sql,new BeanListHandler<Users>(Users.class));
        }catch (SQLException e){
            e.printStackTrace();
        }
        return li;
    }

    public Users selestOne(String username,String password) {
       // ComboPooledDataSource co= PoolUtil.getCom();
        QueryRunner qr=new QueryRunner(PoolUtil.getCom());
        String sql="select * from users where uname = ? and psd=? ";
        Users u =null;
        try{
           u =qr.query(sql,new BeanHandler<Users>(Users.class),username,password);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return u;
    }
}
