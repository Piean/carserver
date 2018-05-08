package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.ReportEntity;
import com.maple.web.carserver.domain.UserEntity;
import net.sf.json.JSONArray;

import java.util.List;
import java.util.Map;

public interface ReportService {
    Integer count();

    List<UserEntity> selectUserList(Integer page);

    List<ReportEntity> selectByUserId(Integer userId);

    List<Map<String, Integer>> getReportResult();

    void saveMap(JSONArray reportArray, Integer userId);
}
