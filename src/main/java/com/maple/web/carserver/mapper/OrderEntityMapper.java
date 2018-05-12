package com.maple.web.carserver.mapper;

import com.maple.web.carserver.dao.OrderDao;
import com.maple.web.carserver.domain.OrderEntity;

import java.util.List;

public interface OrderEntityMapper {
    Integer count();

    List<OrderDao> getListByPage(Integer start);

    OrderEntity getById(Integer id);

    Integer insert(OrderEntity order);

    Integer update(OrderEntity order);

    Integer delete(Integer id);
}
