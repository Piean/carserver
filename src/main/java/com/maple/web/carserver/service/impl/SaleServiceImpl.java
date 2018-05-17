package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.dao.SaleDao;
import com.maple.web.carserver.domain.SaleEntity;
import com.maple.web.carserver.mapper.SaleEntityMapper;
import com.maple.web.carserver.service.SaleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SaleServiceImpl implements SaleService {

    @Resource
    private SaleEntityMapper entityMapper;


    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<SaleDao> selectByPageNumber(Integer pageNumber, String keyword) {
        return entityMapper.selectByPageNumber(pageNumber * 8,keyword);
    }

    @Override
    public List<SaleDao> getAllSale() {
        return entityMapper.getAllSale();
    }

    @Override
    public SaleEntity getById(Integer id) {
        return entityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(SaleEntity saleEntity) {
        saleEntity.setCreateTime(new Date());
        return entityMapper.insert(saleEntity);
    }

    @Override
    public Integer update(SaleEntity saleEntity) {
        return entityMapper.updateByPrimaryKeySelective(saleEntity);
    }

}
