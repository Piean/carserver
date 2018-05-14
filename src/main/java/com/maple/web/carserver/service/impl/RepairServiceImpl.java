package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.RepairEntity;
import com.maple.web.carserver.mapper.RepairEntityMapper;
import com.maple.web.carserver.service.RepairService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {

    @Resource
    private RepairEntityMapper entityMapper;

    @Override
    public Integer count() {
        return entityMapper.count();
    }

    @Override
    public List<RepairEntity> selectByPageNumber(Integer pageNumber) {
        return entityMapper.selectByPageNumber(pageNumber * 5);
    }

    @Override
    public List<RepairEntity> getListByUserId(Integer userId) {
        return entityMapper.getListByUserId(userId);
    }

    @Override
    public RepairEntity getById(Integer id) {
        return entityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer delete(Integer id) {
        return entityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer insert(RepairEntity repairEntity) {
        repairEntity.setCreateTime(new Date());
        return entityMapper.insert(repairEntity);
    }

    @Override
    public Integer update(RepairEntity repairEntity) {
        return entityMapper.updateByPrimaryKeySelective(repairEntity);
    }

}
