package com.itdr.dao;

import com.itdr.pojo.Orders;
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
public class OrderDao {
    public List<Orders> selectAll ( String pageSize, String pageNum ) {
        // ComboPooledDataSource co=PoolUtil.getCom();
        QueryRunner qr = new QueryRunner(getCom());
        String sql = "select * from orders";
        List<Orders> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Orders>(Orders.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;

    }
   /* public Product selectOne( String username, String password ) {
        // ComboPooledDataSource co=getCom();
        QueryRunner qr=new QueryRunner(getCom());
        String sql;
        sql = "select * from users where name=? and password=?";
        Users u=null;
        try {
            u= qr.query(sql,new BeanHandler<Users>(Users.class),username,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  u;

    }*/

    public Orders selectOne ( Integer id ) {
        QueryRunner qr = new QueryRunner(getCom());

        String sql = "select * from orders where id=?";
        Orders u = null;
        try {
            u = qr.query(sql, new BeanHandler<Orders>(Orders.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;

    }

    public Orders orderSecrch ( String productid, String productname ) {
        QueryRunner qr = new QueryRunner(getCom());

        String sql = "select * from orders where id=? name=?";
        Orders u = null;
        try {
            u = qr.query(sql, new BeanHandler<Orders>(Orders.class), productid, productname
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;

    }

    public Orders orderSecrchid ( Integer productid ) {
        QueryRunner qr = new QueryRunner(getCom());

        String sql = "select * from orders where order_no=? ";
        Orders u = null;
        try {
            u = qr.query(sql, new BeanHandler<Orders>(Orders.class), productid
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public Orders orderSecrchName ( String productname ) {
        QueryRunner qr = new QueryRunner(getCom());

        String sql = "select * from orders where name=? ";
        Orders u = null;
        try {
            u = qr.query(sql, new BeanHandler<Orders>(Orders.class), productname
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public Orders detail ( Long order_no ) {
        QueryRunner qr = new QueryRunner(getCom());

        String sql = "select * from orders where order_no=? ";
        Orders u = null;
        try {
            u = qr.query(sql, new BeanHandler<Orders>(Orders.class), order_no
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public int send_goods ( Long order_no) {
        QueryRunner qr=new QueryRunner(getCom());

        String sql = "update orders set status=40 where order_no=?";
        int row=0;
        try {
            row= qr.update(sql,order_no);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  row;

    }
}
