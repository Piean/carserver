package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.QuestionEntity;

import java.util.List;

public interface QuestionService {

    List<QuestionEntity> getQuestionList();

    int insert(QuestionEntity questionEntity);
    int updatre(QuestionEntity questionEntity);
    int delete(Integer id);

}
