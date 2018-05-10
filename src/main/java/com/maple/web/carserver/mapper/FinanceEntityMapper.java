package com.maple.web.carserver.mapper;

import com.maple.web.carserver.domain.FinanceEntity;
import com.maple.web.carserver.domain.SaleEntity;

import java.util.List;

public interface FinanceEntityMapper {

    /**
     * 总数
     *
     * @return
     */
    Integer count();

    Double earning();

    Double expend();

    /**
     * 分页获取数据
     *
     * @param start
     * @return
     */
    List<FinanceEntity> selectByPageNumber(Integer start);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_finance
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_finance
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insert(FinanceEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_finance
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insertSelective(FinanceEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_finance
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    FinanceEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_finance
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKeySelective(FinanceEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_finance
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKey(FinanceEntity record);
}