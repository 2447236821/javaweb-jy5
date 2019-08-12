package com.itdr.pojo;

import java.util.Date;

/**
 * Created by username on 2019/8/11.
 */
public class Caetgory {
    private Integer id;
    private Integer parent_Id;
    private  String name;
    private Integer status;
    private  Integer sort_order;
    private Date create_time;
    private Date update_time;

    public Integer getId () {
        return id;
    }

    public void setId ( Integer id ) {
        this.id = id;
    }

    public Integer getParent_Id () {
        return parent_Id;
    }

    public void setParent_Id ( Integer parent_Id ) {
        this.parent_Id = parent_Id;
    }

    public String getName () {
        return name;
    }

    public void setName ( String name ) {
        this.name = name;
    }

    public Integer getStatus () {
        return status;
    }

    public void setStatus ( Integer status ) {
        this.status = status;
    }

    public Integer getSort_order () {
        return sort_order;
    }

    public void setSort_order ( Integer sort_order ) {
        this.sort_order = sort_order;
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
        return "Caetgory{" +
                "id=" + id +
                ", parent_Id=" + parent_Id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", sort_order=" + sort_order +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }
}
