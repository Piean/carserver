package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.QuestionEntity;
import com.maple.web.carserver.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    /**
     * 获取所有问题和答案
     * @return
     */
    @RequestMapping("/getQuestionList")
    public List<QuestionEntity> getQuestionList(Integer pageNumber) {
        return questionService.getQuestionList();
    }

    @RequestMapping("/insert")
    public Integer addQuestion(QuestionEntity questionEntity) {
        return questionService.insert(questionEntity);
    }

    @RequestMapping("/update")
    public Integer updateQuestion(QuestionEntity questionEntity) {
        return questionService.updatre(questionEntity);
    }

    @RequestMapping("/delete")
    public Integer delQuestion(Integer id) {
        return questionService.delete(id);
    }
}
