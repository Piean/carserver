package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.RepairEntity;

import java.util.List;

public interface RepairService {
    Integer count();

    List<RepairEntity> selectByPageNumber(Integer pageNumber);

    RepairEntity getById(Integer id);

    Integer delete(Integer id);

    Integer insert(RepairEntity repairEntity);

    Integer update(RepairEntity repairEntity);
}
