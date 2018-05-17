package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.IndentEntity;

import java.util.List;

/**
 * Created by mogu
 * Date: 2018/5/14
 */
public interface IndentService {
    Integer insert(IndentEntity indentEntity);
    Integer update(IndentEntity indentEntity);
    Integer delete(Integer id);

    IndentEntity getById(Integer id);

    Integer count();

    List<IndentEntity> getListByPage(Integer page, String keyword);

    List<IndentEntity> getListByUser(Integer userId);
}
