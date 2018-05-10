package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.QuestionEntity;
import com.maple.web.carserver.mapper.QuestionEntityMapper;
import com.maple.web.carserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Resource
    private QuestionEntityMapper questionEntityMapper;


    @Override
    public List<QuestionEntity> getQuestionList() {
        return questionEntityMapper.selectAllResult();
    }

    @Override
    public int insert(QuestionEntity questionEntity) {
        return questionEntityMapper.insertSelective(questionEntity);
    }

    @Override
    public int updatre(QuestionEntity questionEntity) {
        return questionEntityMapper.updateByPrimaryKeySelective(questionEntity);
    }

    @Override
    public int delete(Integer id) {
        return questionEntityMapper.deleteByPrimaryKey(id);
    }

}
