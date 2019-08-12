package com.itdr.pojo;

import java.util.Date;

/**
 * Created by username on 2019/8/11.
 */
public class Product_details {
    private Integer id;
    private Integer category_id;
    private Integer parentCategoryId;
    private String name;
    private String subtitle;
    private String imageHost;
    private String main_image;
    private String subImages;
    private Double price;
    private Integer stock;
    private Integer status;
    private Date createTime;
    private Date updateTime;

    public Integer getId () {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Integer getCategory_id () {
        return category_id;
    }

    public void setCategory_id ( Integer category_id ) {
        this.category_id = category_id;
    }

    public Integer getParentCategoryId () {
        return parentCategoryId;
    }

    public void setParentCategoryId ( Integer parentCategoryId ) {
        this.parentCategoryId = parentCategoryId;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public String getSubtitle () {
        return subtitle;
    }

    public void setSubtitle ( String subtitle ) {
        this.subtitle = subtitle;
    }

    public String getImageHost () {
        return imageHost;
    }

    public void setImageHost ( String imageHost ) {
        this.imageHost = imageHost;
    }

    public String getMain_image () {
        return main_image;
    }

    public void setMain_image ( String main_image ) {
        this.main_image = main_image;
    }

    public String getSubImages () {
        return subImages;
    }

    public void setSubImages ( String subImages ) {
        this.subImages = subImages;
    }

    public Double getPrice () {
        return price;
    }

    public void setPrice ( Double price ) {
        this.price = price;
    }

    public Integer getStock () {
        return stock;
    }

    public void setStock ( Integer stock ) {
        this.stock = stock;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus ( Integer status ) {
        this.status = status;
    }

    public Date getCreateTime () {
        return createTime;
    }

    public void setCreateTime ( Date createTime ) {
        this.createTime = createTime;
    }

    public Date getUpdateTime () {
        return updateTime;
    }

    public void setUpdateTime ( Date updateTime ) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString () {
        return "Product_details{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", parentCategoryId=" + parentCategoryId +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", imageHost='" + imageHost + '\'' +
                ", main_image='" + main_image + '\'' +
                ", subImages='" + subImages + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", status=" + status +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
