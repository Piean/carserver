package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.GoodsEntity;
import com.maple.web.carserver.mapper.GoodsEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GoodsServiceImpl implements com.maple.web.carserver.service.GoodsService {

    @Autowired
    private GoodsEntityMapper entityMapper;


    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<GoodsEntity> selectByPageNumber(Integer pageNumber) {
        return entityMapper.selectByPageNumber(pageNumber * 8);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(GoodsEntity goodsEntity) {
        goodsEntity.setCreateTime(new Date());
        return entityMapper.insertSelective(goodsEntity);
    }

    @Override
    public Integer update(GoodsEntity goodsEntity) {
        goodsEntity.setCreateTime(new Date());
        return entityMapper.updateByPrimaryKeySelective(goodsEntity);
    }

    @Override
    public List<GoodsEntity> getAll() {
        return entityMapper.getAll();
    }


}
