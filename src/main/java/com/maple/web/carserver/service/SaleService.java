package com.maple.web.carserver.service;

import com.maple.web.carserver.dao.SaleDao;
import com.maple.web.carserver.domain.SaleEntity;

import java.util.List;

public interface SaleService {
    Integer count();

    List<SaleDao> selectByPageNumber(Integer pageNumber);

    List<SaleDao> getAllSale();

    SaleEntity getById(Integer id);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(SaleEntity saleEntity);

    Integer update(SaleEntity saleEntity);
}
