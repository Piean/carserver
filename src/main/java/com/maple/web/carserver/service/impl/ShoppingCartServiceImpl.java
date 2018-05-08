package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.dao.ShoppingCartDao;
import com.maple.web.carserver.dao.ShoppingCartParamsDto;
import com.maple.web.carserver.domain.ShoppingCartEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.mapper.ShoppingCartEntityMapper;
import com.maple.web.carserver.mapper.UserEntityMapper;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements com.maple.web.carserver.service.ShoppingCartService {

    @Autowired
    private ShoppingCartEntityMapper entityMapper;

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Override
    public Integer count(Integer userId) {
        return entityMapper.count(userId);
    }

    @Override
    public List<ShoppingCartDao> selectGoodsList(Integer userId) {
        return entityMapper.selectGoodsList(userId);
    }

    @Override
    public Integer delete(ShoppingCartParamsDto paramsDto) {
        ShoppingCartEntity entity = entityMapper.selectByGoodsId(paramsDto.toEntity());
        return entityMapper.deleteByPrimaryKey(entity.getId());
    }

    @Override
    public Integer updateCount(ShoppingCartParamsDto paramsDto) {
        ShoppingCartEntity entity = entityMapper.selectByGoodsId(paramsDto.toEntity());
        entity.setCount(paramsDto.getCount());
        return entityMapper.updateByPrimaryKeySelective(entity);
    }


    @Override
    public Integer saveOrUpdate(ShoppingCartEntity shoppingCartEntity) {
        ShoppingCartEntity entity;
        if ((entity = entityMapper.selectByGoodsId(shoppingCartEntity)) != null) {
            entity.setCount(entity.getCount() + 1);
            return entityMapper.updateByPrimaryKeySelective(entity);
        } else {
            shoppingCartEntity.setCreateTime(new Date());
            return entityMapper.insertSelective(shoppingCartEntity);
        }
    }

    @Override
    @Transactional
    public Integer buyAllGoods(Integer userId, Double realSum) {
        UserEntity userEntity = userEntityMapper.selectByPrimaryKey(userId);
        double integral;
        if (userEntity.getIntegral() == null) {
            integral = 0;
        } else {
            integral = Double.parseDouble(userEntity.getIntegral());
        }
        if (integral >= realSum) {
            userEntity.setIntegral((integral - realSum) + "");
            userEntityMapper.updateByPrimaryKeySelective(userEntity);
            return entityMapper.buyAllGoods(userId);
        } else {
            return -1;
        }
    }

}
