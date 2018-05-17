package com.maple.web.carserver.mapper;

import com.maple.web.carserver.domain.IndentEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IndentEntityMapper {
    Integer insert(IndentEntity indentEntity);
    Integer update(IndentEntity indentEntity);
    Integer delete(Integer id);

    IndentEntity getById(Integer id);

    Integer count();

    List<IndentEntity> getListByPage(@Param("start") Integer start, @Param("keyword") String keyword);

    List<IndentEntity> getListByUser(Integer userId);
}