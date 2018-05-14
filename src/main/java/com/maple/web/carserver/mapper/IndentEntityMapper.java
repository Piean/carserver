package com.maple.web.carserver.mapper;

import com.maple.web.carserver.domain.IndentEntity;

import java.util.List;

public interface IndentEntityMapper {
    Integer insert(IndentEntity indentEntity);
    Integer update(IndentEntity indentEntity);
    Integer delete(Integer id);

    IndentEntity getById(Integer id);

    Integer count();

    List<IndentEntity> getListByPage(Integer page);
}