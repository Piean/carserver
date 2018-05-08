package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.service.UserService;
import com.maple.web.carserver.utils.SessionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;


@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    UserService userService;

    /**
     * 登录
     *
     * @param username
     * @param password
     * @param response
     * @param userType
     * @return
     */
    @RequestMapping("/doLogin")
    public UserEntity doLogin(String username, String password, HttpServletResponse response, Integer userType, HttpServletRequest request) {
        UserEntity userDO = userService.doLogin(username, password, userType, request.getSession().getId());
        if (userDO == null) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        return userDO;
    }

    /**
     * 注册
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/doRegister")
    public Integer doRegister(String username, String password) {
        Integer id = userService.doRegister(username, password);
        return id;
    }

    /**
     * 用户数量
     *
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return userService.count();
    }

    /**
     * 用户信息分页查询
     *
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectUserByPageNumber")
    public List<UserEntity> selectUserByPageNumber(Integer pageNumber) {
        return userService.selectUserByPageNumber(pageNumber);
    }

    /**
     * 添加用户
     *
     * @param userEntity
     * @return
     */
    @RequestMapping("/addAccount")
    public Integer addAccount(UserEntity userEntity) {
        return userService.addAccount(userEntity);
    }

    /**
     * 删除某个用户
     *
     * @param id
     * @return
     */
    @RequestMapping("/delAccountById")
    public Integer delAccountById(Integer id) {
        return userService.deleteByPrimaryKey(id);
    }

    /**
     * 更新用户信息
     *
     * @param userEntity
     * @return
     */
    @RequestMapping("/updateAccount")
    public Integer updateAccount(UserEntity userEntity) {
        return userService.updateAccount(userEntity);
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @param request
     * @return
     */
    @RequestMapping("/getUserInfo")
    public UserEntity getUserInfo(Integer userId, HttpServletRequest request) {
        if (userId == null || userId == 0) {
            userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        }
        return userService.getUserInfo(userId);
    }

}
