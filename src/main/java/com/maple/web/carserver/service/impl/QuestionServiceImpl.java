package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.QuestionEntity;
import com.maple.web.carserver.mapper.QuestionEntityMapper;
import com.maple.web.carserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private QuestionEntityMapper questionEntityMapper;


    @Override
    public List<QuestionEntity> getQuestionList() {
        return questionEntityMapper.selectAllResult();
    }

}
