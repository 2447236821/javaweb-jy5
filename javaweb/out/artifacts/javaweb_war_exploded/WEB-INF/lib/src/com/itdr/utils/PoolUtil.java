package com.itdr.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by username on 2019/8/5.
 */
public class PoolUtil {
    public static ComboPooledDataSource  co= new ComboPooledDataSource();
    public static ComboPooledDataSource getCom(){
        return co;
    }
}
