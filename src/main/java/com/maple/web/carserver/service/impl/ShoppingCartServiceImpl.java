package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.dao.ShoppingCartDao;
import com.maple.web.carserver.dao.ShoppingCartParamsDto;
import com.maple.web.carserver.domain.ShoppingCartEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.mapper.ShoppingCartEntityMapper;
import com.maple.web.carserver.mapper.UserEntityMapper;
import com.maple.web.carserver.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    @Resource
    private ShoppingCartEntityMapper entityMapper;

    @Resource
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
    public ShoppingCartEntity getById(Integer userId, Integer goodsId) {
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setTbUserId(userId);
        entity.setTbGoodsId(goodsId);
        return entityMapper.selectByGoodsId(entity);
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
        if (userEntity.getIntegral() == null || realSum == null) {
            return -1;
        }
        if (userEntity.getIntegral() >= realSum) {
            userEntity.setIntegral(userEntity.getIntegral() - realSum);
            userEntityMapper.updateByPrimaryKeySelective(userEntity);
            return entityMapper.buyAllGoods(userId);
        } else {
            return -1;
        }
    }

}
