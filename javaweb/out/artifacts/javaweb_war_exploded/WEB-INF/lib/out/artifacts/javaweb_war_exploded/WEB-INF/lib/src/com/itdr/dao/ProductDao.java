package com.itdr.dao;

import com.itdr.pojo.Product;
import com.itdr.utils.PoolUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by username on 2019/8/11.
 */
public class ProductDao {
    public List<Product> productlistAll(String pageSize, String pageNum) {
        QueryRunner qr = new QueryRunner(PoolUtil.getCom());
        String sql = "select * from product limit ?,?";
        List<Product> li = null;
        try {
            li = qr.query(sql, new BeanListHandler<Product>(Product.class), 1, 10);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return li;
    }
}
