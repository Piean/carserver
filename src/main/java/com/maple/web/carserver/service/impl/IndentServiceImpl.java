package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.IndentEntity;
import com.maple.web.carserver.mapper.IndentEntityMapper;
import com.maple.web.carserver.service.IndentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by mogu
 * Date: 2018/5/14
 */
@Service
public class IndentServiceImpl implements IndentService {
    @Resource
    private IndentEntityMapper indentEntityMapper;

    @Override
    public Integer insert(IndentEntity indentEntity) {
        return indentEntityMapper.insert(indentEntity);
    }

    @Override
    public Integer update(IndentEntity indentEntity) {
        return indentEntityMapper.update(indentEntity);
    }

    @Override
    public Integer delete(Integer id) {
        return indentEntityMapper.delete(id);
    }

    @Override
    public IndentEntity getById(Integer id) {
        return indentEntityMapper.getById(id);
    }

    @Override
    public Integer count() {
        return indentEntityMapper.count();
    }

    @Override
    public List<IndentEntity> getListByPage(Integer page) {
        return indentEntityMapper.getListByPage(page * 8);
    }
}
