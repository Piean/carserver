package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.dao.StoreDao;
import com.maple.web.carserver.domain.StoreEntity;
import com.maple.web.carserver.mapper.StoreEntityMapper;
import com.maple.web.carserver.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreEntityMapper entityMapper;

    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<StoreDao> selectByPageNumber(Integer pageNumber) {
        return entityMapper.selectByPageNumber(pageNumber * 8);
    }

    @Override
    public Integer delete(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(StoreEntity storeEntity) {
        storeEntity.setCreateTime(new Date());
        return entityMapper.insertSelective(storeEntity);
    }

    @Override
    public Integer update(StoreEntity storeEntity) {
        return entityMapper.updateByPrimaryKeySelective(storeEntity);
    }

}
