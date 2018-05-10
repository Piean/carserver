package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.FinanceEntity;

import java.util.List;

public interface FinanceService {
    Integer count();

    double earning();

    double expend();

    List<FinanceEntity> selectByPageNumber(Integer pageNumber);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(FinanceEntity financeEntity);

    Integer update(FinanceEntity financeEntity);
}
