package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.SaleEntity;

import java.util.List;

public interface SaleService {
    Integer count();

    List<SaleEntity> selectByPageNumber(Integer pageNumber);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(SaleEntity saleEntity);

    Integer update(SaleEntity saleEntity);
}
