package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.ReportEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.mapper.ReportEntityMapper;
import com.maple.web.carserver.service.ReportService;
import com.maple.web.carserver.utils.SessionUtil;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportEntityMapper mapper;


    @Override
    public Integer count() {
        return mapper.count();
    }

    @Override
    public List<UserEntity> selectUserList(Integer page) {
        return mapper.selectUserList(page * 8);
    }

    @Override
    public List<ReportEntity> selectByUserId(Integer userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public List<Map<String, Integer>> getReportResult() {
        List<ReportEntity> entityList = mapper.getReportResult();
        List<Map<String, Integer>> result = new ArrayList<>();
        result.add(getReportMap(entityList, 1));
        result.add(getReportMap(entityList, 2));
        result.add(getReportMap(entityList, 3));
        result.add(getReportMap(entityList, 4));
        return result;
    }

    @Override
    public void saveMap(JSONArray reportArray, Integer userId) {

        for (int i = 1; i <= 5; i++) {
            mapper.insertSelective(new ReportEntity(userId, i, reportArray.getString(i - 1)));
        }
    }

    public static Map<String, Integer> getReportMap(List<ReportEntity> entities, @NotNull Integer questionNumber) {
        Map<String, Integer> map = new HashMap<>();
        for (ReportEntity entity : entities) {
            if (questionNumber.equals(entity.getQuestionId())) {
                if (!map.containsKey(entity.getAnswer())) {
                    map.put(entity.getAnswer(), 1);
                } else {
                    map.put(entity.getAnswer(), map.get(entity.getAnswer()) + 1);
                }
            }
        }
        return map;
    }
}
