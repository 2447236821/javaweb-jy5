package com.itdr.common;

/**
 * Created by username on 2019/8/5.
 */
public class ResponseCode<T> {
    private  Integer status;
    private T data;
    private String mag;

    public Integer getStatus () {
        return status;
    }

    public void setStatus ( Integer status ) {
        this.status = status;
    }

    public T getData () {
        return data;
    }

    public void setData ( T data ) {
        this.data = data;
    }

    public String getMag () {
        return mag;
    }

    public void setMag ( String mag ) {
        this.mag = mag;
    }
    public  static <T> ResponseCode successRs(Integer status,T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(status);
        rs.setData(data);
        return rs;

    }
    public  static <T> ResponseCode successRs(T data){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(0);
        rs.setData(data);
        return rs;

    }
    public  static <T> ResponseCode defeatdeRs(Integer status,String mag){
        ResponseCode rs=new ResponseCode();
        rs.setStatus(status);
        rs.setMag(mag);
        return rs;

    }

    @Override
    public String toString () {
        return "ResponseCode{" +
                "status=" + status +
                ", data=" + data +
                ", mag='" + mag + '\'' +
                '}';
    }

}
