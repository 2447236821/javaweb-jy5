package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.pojo.Product_details;
import com.itdr.utils.PathUtil;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

import static com.itdr.utils.PoolUtil.getCom;

/**
 * Created by username on 2019/8/11.
 */
public class ProductDao {
    public List<Product> selectAll ( String pageSize, String pageNum ) {
        //ComboPooledDataSource co=PoolUtil.getCom();
        QueryRunner qr=new QueryRunner(getCom());
        String sql="select * from product";
        List<Product> li=null;
        try {
            li= qr.query(sql,new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  li;

    }
    public Product selectOne( String name, Integer id ) {
        // ComboPooledDataSource co=getCom();
        QueryRunner qr=new QueryRunner(getCom());
        String sql;
        sql = "select * from users where name=? and id=?";
        Product u=null;
        try {
            u= qr.query(sql,new BeanHandler<Product>(Product.class),name,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;

    }

    public  Product selectOne ( Integer id ) {
        QueryRunner qr=new QueryRunner(getCom());

        String sql = "select * from product where id=?";
        Product u=null;
        try {
            u= qr.query(sql,new BeanHandler<Product>(Product.class),id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;

    }

    public Product productSecrch ( String productid, String productname ) {
        QueryRunner qr=new QueryRunner(getCom());

        String sql = "select * from product where id=? name=?";
        Product u=null;
        try {
            u= qr.query(sql,new BeanHandler<Product>(Product.class),productid,productname
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;

    }

    public Product productSecrchid ( Integer productid ) {
        QueryRunner qr=new QueryRunner(getCom());

        String sql = "select * from product where id=? ";
        Product u=null;
        try {
            u= qr.query(sql,new BeanHandler<Product>(Product.class),productid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;
    }

    public Product productSecrchName ( String productname ) {
        QueryRunner qr=new QueryRunner(getCom());

        String sql = "select * from product where name=? ";
        Product u=null;
        try {
            u= qr.query(sql,new BeanHandler<Product>(Product.class),productname
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;
    }

    public Product_details detail( Integer id ) {
        QueryRunner qr = new QueryRunner(getCom());

        String sql = "select * from product_details where id=? ";
        Product_details u = null;
        try {
            u = qr.query(sql, new BeanHandler<Product_details>(Product_details.class), id
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }


    public int set_sale_status( Integer id,Integer status ) {
        QueryRunner qr=new QueryRunner(getCom());

        String sql = "update product_details set ststs=? where id=?";
        int row=0;
        try {
            row= qr.update(sql,id,status);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;

    }
}
