package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity getUserById(Integer id);

    UserEntity doLogin(String username, String password, Integer isAdmin, String sessionId);

    Integer doRegister(String username, String password);

    List<UserEntity> selectUserByPageNumber(Integer pageNumber);

    int deleteByPrimaryKey(Integer id);

    Integer count();

    Integer addAccount(UserEntity userEntity);

    Integer updateAccount(UserEntity userEntity);

    public UserEntity getUserInfo(Integer userId);
}
