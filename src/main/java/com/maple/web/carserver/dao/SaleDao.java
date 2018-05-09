package com.maple.web.carserver.dao;

import com.maple.web.carserver.domain.SaleEntity;

/**
 * Created by mogu
 * Date: 2018/5/10
 */
public class SaleDao extends SaleEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
