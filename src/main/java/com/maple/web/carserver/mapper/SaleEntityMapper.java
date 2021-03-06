package com.maple.web.carserver.mapper;

import com.maple.web.carserver.dao.SaleDao;
import com.maple.web.carserver.domain.SaleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SaleEntityMapper {


    /**
     * 销售记录总数
     * @return
     */
    Integer count();

    /**
     *  销售记录分页数据
     * @param start
     * @return
     */
    List<SaleDao> selectByPageNumber(@Param("start") Integer start, @Param("keyword") String keyword);

    List<SaleDao> getAllSale();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sale
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sale
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insert(SaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sale
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insertSelective(SaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sale
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    SaleEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sale
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKeySelective(SaleEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sale
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKey(SaleEntity record);
}