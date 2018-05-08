package com.maple.web.carserver.dao;

import java.util.Date;

public class StoreDao {

    private Integer id;
    private Integer count;
    private Integer tbGoodsId;
    private Date createTime;

    // from tb_goods
    private String name;
    private String introduction;
    private String imageUrl;

    public Integer getId() {
        return id;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getTbGoodsId() {
        return tbGoodsId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getName() {
        return name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
