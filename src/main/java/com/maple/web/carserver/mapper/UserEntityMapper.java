package com.maple.web.carserver.mapper;

import com.maple.web.carserver.domain.UserEntity;

import java.util.List;
import java.util.Map;

public interface UserEntityMapper {


    /**
     * 通过 username 筛选用户
     *
     * @param username
     * @return
     */
    UserEntity selectByUsername(String username);

    /**
     * 登录
     *
     * @param params
     * @return
     */
    UserEntity doLogin(Map params);

    /**
     * 注册
     *
     * @param params
     * @return
     */
    Integer doRegister(Map params);

    /**
     * 获取用户总数
     * @return
     */
    Integer count();

    /**
     * 分页获取用户信息
     * @param pageNumber
     * @return
     */
    List<UserEntity> selectUserByPageNumber(Integer pageNumber);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insert(UserEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int insertSelective(UserEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    UserEntity selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKeySelective(UserEntity record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Wed Mar 21 16:07:47 CST 2018
     */
    int updateByPrimaryKey(UserEntity record);
}