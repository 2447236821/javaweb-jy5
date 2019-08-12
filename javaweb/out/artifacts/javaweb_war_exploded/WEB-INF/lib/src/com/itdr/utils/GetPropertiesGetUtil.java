package com.itdr.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by username on 2019/8/8.
 */
public class GetPropertiesGetUtil {
    public static String getValue(String key){
        Properties ps=new Properties();
        InputStream in=GetPropertiesGetUtil.
                class.getClassLoader().getResourceAsStream("Const.properties");
        try{
            ps.load(in);
        }catch (IOException e){
            e.printStackTrace();
        }
        String value=ps.getProperty(key);
        return value;
    }
    public static void main(String[] args){
        System.out.println(getValue("USER_DISABLE_CODE"));
        System.out.println(getValue("USER_DISABLE_MSG"));
    }
}
