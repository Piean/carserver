package com.maple.web.carserver.service;
import com.maple.web.carserver.domain.GoodsEntity;
import java.util.List;

public interface GoodsService {

    Integer count();

    List<GoodsEntity> selectByPageNumber(Integer pageNumber);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(GoodsEntity goodsEntity);

    Integer update(GoodsEntity goodsEntity);

    List<GoodsEntity> getAll();
}
