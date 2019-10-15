package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;

import java.util.List;

/**
 * Created by username on 2019/8/11.
 */
public class ProductService {
    private ProductDao ud=new ProductDao();
    //获取商品列表
    public ResponseCode productlistAll(String pageSize, String pageNum) {
        if (pageSize == null || pageSize.equals("")) {
            pageSize = "10";
        }
        if (pageNum == null || pageSize.equals("")) {
            pageNum = "1";
        }

        List<Product> li = ud.productlistAll(pageSize, pageNum);
        //如果集合元素为空？
        ResponseCode rs = new ResponseCode();
        rs.setStatus(0);
        rs.setData(li);
        return rs;
    }
}
