package com.maple.web.carserver.service;

import com.maple.web.carserver.dao.StoreDao;
import com.maple.web.carserver.domain.StoreEntity;

import java.util.List;

public interface StoreService {
    Integer count();

    List<StoreDao> selectByPageNumber(Integer pageNumber);

    Integer delete(Integer id);

    Integer insert(StoreEntity storeEntity);

    Integer update(StoreEntity storeEntity);
}
