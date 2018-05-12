package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.dao.OrderDao;
import com.maple.web.carserver.domain.OrderEntity;
import com.maple.web.carserver.mapper.OrderEntityMapper;
import com.maple.web.carserver.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderEntityMapper orderMapper;
    @Override
    public Integer count() {
        return orderMapper.count();
    }

    @Override
    public List<OrderDao> getListByPage(Integer page) {
        return orderMapper.getListByPage(page * 8);
    }

    @Override
    public OrderEntity getById(Integer id) {
        return orderMapper.getById(id);
    }

    @Override
    public Integer insert(OrderEntity order) {
        return orderMapper.insert(order);
    }

    @Override
    public Integer update(OrderEntity order) {
        return orderMapper.update(order);
    }

    @Override
    public Integer delete(Integer id) {
        return orderMapper.delete(id);
    }
}
