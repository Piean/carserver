package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.FinanceEntity;
import com.maple.web.carserver.mapper.FinanceEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FinanceServiceImpl implements com.maple.web.carserver.service.FinanceService {

    @Autowired
    private FinanceEntityMapper entityMapper;

    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<FinanceEntity> selectByPageNumber(Integer pageNumber) {
        return entityMapper.selectByPageNumber(pageNumber * 8);
    }

    @Override
    public Integer deleteByPrimaryKey(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(FinanceEntity financeEntity) {
        financeEntity.setCreateTime(new Date());
        return entityMapper.insertSelective(financeEntity);
    }

    @Override
    public Integer update(FinanceEntity financeEntity) {
        return entityMapper.updateByPrimaryKeySelective(financeEntity);
    }
}
