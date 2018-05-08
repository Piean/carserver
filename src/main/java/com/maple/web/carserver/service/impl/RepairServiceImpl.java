package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.RepairEntity;
import com.maple.web.carserver.mapper.RepairEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RepairServiceImpl implements com.maple.web.carserver.service.RepairService {

    @Autowired
    private RepairEntityMapper entityMapper;

    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<RepairEntity> selectByPageNumber(Integer pageNumber) {
        return entityMapper.selectByPageNumber(pageNumber * 8);
    }

    @Override
    public Integer delete(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(RepairEntity repairEntity) {
        repairEntity.setCreateTime(new Date());
        return entityMapper.insertSelective(repairEntity);
    }

    @Override
    public Integer update(RepairEntity repairEntity) {
        RepairEntity entity = entityMapper.selectByPrimaryKey(repairEntity.getId());
        entity.setIsRepair(repairEntity.getIsRepair());
        return entityMapper.updateByPrimaryKeySelective(repairEntity);
    }

}
