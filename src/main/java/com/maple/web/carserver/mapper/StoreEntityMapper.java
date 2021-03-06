package com.maple.web.carserver.mapper;

import com.maple.web.carserver.dao.StoreDao;
import com.maple.web.carserver.domain.StoreEntity;

import java.util.List;

public interface StoreEntityMapper {

    /**
     *
     * @return
     */
    Integer count();

    /**
     * @param pageNumber
     * @return
     */
    List<StoreDao> selectByPageNumber(Integer pageNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_store
     *
     * @mbg.generated Tue Apr 17 22:42:23 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_store
     *
     * @mbg.generated Tue Apr 17 22:42:23 CST 2018
     */
    int insert(StoreEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_store
     *
     * @mbg.generated Tue Apr 17 22:42:23 CST 2018
     */
    int insertSelective(StoreEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_store
     *
     * @mbg.generated Tue Apr 17 22:42:23 CST 2018
     */
    StoreEntity selectByPrimaryKey(Integer id);

    StoreEntity getByGoodsId(Integer goodsId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_store
     *
     * @mbg.generated Tue Apr 17 22:42:23 CST 2018
     */
    int updateByPrimaryKeySelective(StoreEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_store
     *
     * @mbg.generated Tue Apr 17 22:42:23 CST 2018
     */
    int updateByPrimaryKey(StoreEntity record);
}