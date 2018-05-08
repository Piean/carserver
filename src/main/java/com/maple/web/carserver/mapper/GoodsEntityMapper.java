package com.maple.web.carserver.mapper;

import com.maple.web.carserver.domain.GoodsEntity;

import java.util.List;

public interface GoodsEntityMapper {


    /**
     * 总数
     *
     * @return
     */
    Integer count();

    /**
     * 分页获取
     *
     * @param start
     * @return
     */
    List<GoodsEntity> selectByPageNumber(Integer start);

    List<GoodsEntity> getAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insert(GoodsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insertSelective(GoodsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    GoodsEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKeySelective(GoodsEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_goods
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKey(GoodsEntity record);
}