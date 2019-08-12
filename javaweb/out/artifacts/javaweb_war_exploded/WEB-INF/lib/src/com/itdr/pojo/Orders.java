package com.itdr.pojo;

import java.util.Date;

/**
 * Created by username on 2019/8/11.
 */
public class Orders {
    private Integer id;
    private  Integer user_id;
    private Long order_no;
    private  Integer shipping_id;
    private  Double payment;
    private  Integer payment_type;
    private  Integer postage;
    private Integer status;
    private Date payment_time;
    private Date send_time;
    private Date end_time;
    private  Date close_time;
    private Date create_time;
    private  Date update_time;

    public Integer getId () {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Integer getUserId () {
        return user_id;
    }

    public void setUserId ( Integer userId ) {
        this.user_id = userId;
    }

    public Long getOrder_on () {
        return order_no;
    }

    public void setOrder_on ( Long order_on ) {
        this.order_no = order_on;
    }

    public Integer getShipping_id () {
        return shipping_id;
    }

    public void setShipping_id ( Integer shipping_id ) {
        this.shipping_id = shipping_id;
    }

    public Double getPayment () {
        return payment;
    }

    public void setPayment ( Double payment ) {
        this.payment = payment;
    }

    public Integer getPayment_type () {
        return payment_type;
    }

    public void setPayment_type ( Integer payment_type ) {
        this.payment_type = payment_type;
    }

    public Integer getPostage () {
        return postage;
    }

    public void setPostage ( Integer postage ) {
        this.postage = postage;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus ( Integer status ) {
        this.status = status;
    }

    public Date getPayment_time () {
        return payment_time;
    }

    public void setPayment_time ( Date payment_time ) {
        this.payment_time = payment_time;
    }

    public Date getSend_time () {
        return send_time;
    }

    public void setSend_time ( Date send_time ) {
        this.send_time = send_time;
    }

    public Date getGetSend_time () {
        return end_time;
    }

    public void setGetSend_time ( Date getSend_time ) {
        this.end_time = getSend_time;
    }

    public Date getClose_time () {
        return close_time;
    }

    public void setClose_time ( Date close_time ) {
        this.close_time = close_time;
    }

    public Date getCreate_time () {
        return create_time;
    }

    public void setCreate_time ( Date create_time ) {
        this.create_time = create_time;
    }

    public Date getUpdate_time () {
        return update_time;
    }

    public void setUpdate_time ( Date update_time ) {
        this.update_time = update_time;
    }

    @Override
    public String toString () {
        return "Order{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", order_no=" + order_no +
                ", shipping_id=" + shipping_id +
                ", payment=" + payment +
                ", payment_type=" + payment_type +
                ", postage=" + postage +
                ", status=" + status +
                ", payment_time=" + payment_time +
                ", send_time=" + send_time +
                ", end_time=" + end_time +
                ", close_time=" + close_time +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
