package com.itdr.utils;

/**
 * Created by username on 2019/8/5.
 */
public class PathUtil {
    public static String getPath(String path){
        String s1=path.replace(".","/");
        String[] sar=s1.split("/");
        return sar[1];
    }
}
