package com.maple.web.carserver.mapper;

import com.maple.web.carserver.domain.QuestionEntity;
import org.springframework.aop.target.LazyInitTargetSource;

import java.util.List;

public interface QuestionEntityMapper {

    /**
     * 获取所有问题
     * @return
     */
    List<QuestionEntity> selectAllResult();


    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insert(QuestionEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insertSelective(QuestionEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    QuestionEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKeySelective(QuestionEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_question
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKey(QuestionEntity record);


}