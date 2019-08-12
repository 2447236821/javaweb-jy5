package com.itdr.dao;

import com.itdr.pojo.Caetgory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static com.itdr.utils.PoolUtil.getCom;

/**
 * Created by username on 2019/8/11.
 */
public class CaetgoryDao {
    public List<Caetgory> selectAll (Integer categoryId) {
        //ComboPooledDataSource co=PoolUtil.getCom();
        QueryRunner qr=new QueryRunner(getCom());
        String sql="select * from category";
        List<Caetgory> li=null;
        try {
            li= qr.query(sql,new BeanListHandler<Caetgory>(Caetgory.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  li;

    }
    public  int add_category(Integer parentId,String categoryName){
        QueryRunner qr=new QueryRunner(getCom());
        String sql="insert into category  VALUEs(null,"+parentId+",'"+categoryName+"',1,null,SYSDATE(),SYSDATE())  ";
        int a=0;
        try {
            a= qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  a;
    }


    public Integer category_name ( Integer ids, String categoryName ) {
        QueryRunner qr = new QueryRunner(getCom());
        String sql = "UPDATE category set name='" + categoryName + "' WHERE  id=" + ids;
        int a = 0;
        try {
            a = qr.update(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return a;
    }
}
