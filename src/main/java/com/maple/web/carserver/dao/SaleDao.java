package com.maple.web.carserver.dao;

import com.maple.web.carserver.domain.SaleEntity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mogu
 * Date: 2018/5/10
 */
public class SaleDao extends SaleEntity {
    private String name;

    @Override
    public Integer getId() {
        return id == null ? 0 : id;
    }

    @Override
    public Integer getGoodsId() {
        return goodsId == null ? 0 : goodsId;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    @Override
    public Double getPrice() {
        return price == null ? 0 : price;
    }

    @Override
    public String getSalerName() {
        return salerName == null ? "" : salerName;
    }

    @Override
    public Double getAmount() {
        return amount == null ? 0 : amount;
    }

    @Override
    public Integer getCount() {
        return count == null ? 0 : count;
    }

    @Override
    public String getIntroduction() {
        return introduction == null ? "" : introduction;
    }

    public String getDate() {
        return createTime == null ? "" : new SimpleDateFormat("yyyy-MM-dd").format(createTime.getTime());
    }
}
