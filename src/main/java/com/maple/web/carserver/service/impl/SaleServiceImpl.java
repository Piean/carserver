package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.SaleEntity;
import com.maple.web.carserver.mapper.SaleEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleServiceImpl implements com.maple.web.carserver.service.SaleService {

    @Autowired
    private SaleEntityMapper entityMapper;


    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<SaleEntity> selectByPageNumber(Integer pageNumber) {
        return entityMapper.selectByPageNumber(pageNumber * 8);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(SaleEntity saleEntity) {
        saleEntity.setCreateTime(new Date());
        return entityMapper.insertSelective(saleEntity);
    }

    @Override
    public Integer update(SaleEntity saleEntity) {
        return entityMapper.updateByPrimaryKeySelective(saleEntity);
    }

}
