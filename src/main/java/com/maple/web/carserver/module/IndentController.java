package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.IndentDao;
import com.maple.web.carserver.domain.IndentEntity;
import com.maple.web.carserver.service.IndentService;
import com.maple.web.carserver.service.ShoppingCartService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mogu
 * Date: 2018/5/15
 */
@RestController
@RequestMapping("/indent")
public class IndentController {
    @Resource
    private IndentService indentService;
    @Resource
    private ShoppingCartService shoppingCartService;

    @RequestMapping("/count")
    public Integer count() {
        return indentService.count();
    }

    @RequestMapping("/list")
    public List<IndentDao> getListByPage(Integer pageNumber) {
        List<IndentEntity> indentList = indentService.getListByPage(pageNumber);
        List<IndentDao> result = new ArrayList<>(indentList.size());
        for (IndentEntity indent : indentList) {
            IndentDao dao = new IndentDao();
            try {
                BeanUtils.copyProperties(dao,indent);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
            dao.setCartDetail(shoppingCartService.getByIdList(Arrays.asList(indent.getCartId().split(","))));
            result.add(dao);
        }
        return result;
    }

    @RequestMapping("/update")
    public Integer update(IndentEntity indentEntity) {
        return indentService.update(indentEntity);
    }
}
