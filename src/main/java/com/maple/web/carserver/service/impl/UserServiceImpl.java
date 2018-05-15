package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.mapper.UserEntityMapper;
import com.maple.web.carserver.service.UserService;
import com.maple.web.carserver.utils.SessionUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserEntityMapper userEntityMapper;

    @Override
    public Integer count() {
        return userEntityMapper.count();
    }

    @Override
    public UserEntity getUserById(Integer id) {
        return userEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public UserEntity doLogin(String username, String password, Integer isAdmin, String sessionId) {
        Map<String, String> map = new HashMap();
        map.put("username", username);
        map.put("password", password);
        map.put("isAdmin", isAdmin.toString());
        UserEntity userEntity = userEntityMapper.doLogin(map);
        if (userEntity != null) {
            SessionUtil.getInstance().addSessionId(sessionId, userEntity.getId());
        }
        return userEntity;
    }

    @Override
    public Integer doRegister(String username, String password) {
        if (userEntityMapper.selectByUsername(username) != null) return -1;
        Map<String, String> map = new HashMap();
        map.put("username", username);
        map.put("password", password);
        return userEntityMapper.doRegister(map);
    }

    @Override
    public List<UserEntity> selectUserByPageNumber(Integer pageNumber) {
        return userEntityMapper.selectUserByPageNumber(pageNumber * 8);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userEntityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer addAccount(UserEntity userEntity) {
        if (userEntityMapper.selectByUsername(userEntity.getUsername()) != null) return -1;
        userEntity.setCreateTime(new Date());
        return userEntityMapper.insert(userEntity);
    }

    @Override
    public Integer updateAccount(UserEntity userEntity) {
        return userEntityMapper.updateByPrimaryKeySelective(userEntity);
    }

    public UserEntity getUserInfo(Integer userId) {
        return userEntityMapper.selectByPrimaryKey(userId);
    }

}
