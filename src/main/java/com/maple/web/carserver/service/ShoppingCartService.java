package com.maple.web.carserver.service;

import com.maple.web.carserver.dao.ShoppingCartDao;
import com.maple.web.carserver.dao.ShoppingCartParamsDto;
import com.maple.web.carserver.domain.ShoppingCartEntity;

import java.util.List;

public interface ShoppingCartService {
    Integer count(Integer userId);

    List<ShoppingCartDao> selectGoodsList(Integer userId);

    ShoppingCartEntity getById(Integer userId, Integer goodsId);

    Integer delete(ShoppingCartParamsDto paramsDto);

    Integer updateCount(ShoppingCartParamsDto paramsDto);

    Integer saveOrUpdate(ShoppingCartEntity shoppingCartEntity);

    Integer buyAllGoods(String[] cartIdList);
}
