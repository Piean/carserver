package com.maple.web.carserver.dao;

import com.maple.web.carserver.domain.OrderEntity;

public class OrderDao extends OrderEntity {
    private String carName;

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }
}
