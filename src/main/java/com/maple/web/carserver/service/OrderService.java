package com.maple.web.carserver.service;

import com.maple.web.carserver.dao.OrderDao;
import com.maple.web.carserver.domain.OrderEntity;

import java.util.List;

public interface OrderService {
    Integer count();

    List<OrderDao> getListByPage(Integer page);

    OrderEntity getById(Integer id);

    Integer insert(OrderEntity order);

    Integer update(OrderEntity order);

    Integer delete(Integer id);
}
