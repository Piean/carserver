package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.ShoppingCartDao;
import com.maple.web.carserver.dao.ShoppingCartParamsDto;
import com.maple.web.carserver.domain.ShoppingCartEntity;
import com.maple.web.carserver.domain.StoreEntity;
import com.maple.web.carserver.service.ShoppingCartService;
import com.maple.web.carserver.service.StoreService;
import com.maple.web.carserver.utils.SessionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private StoreService storeService;

    /**
     * 获取某个用户购物车商品
     *
     * @param userId
     * @return
     */
    @RequestMapping("/count")
    public Integer count(Integer userId, HttpServletRequest request) {
        if (userId == null || userId == 0) {
            userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        }
        if (userId == null) return 0;
        return shoppingCartService.count(userId);
    }

    /**
     * 获取某个用户购物车商品
     *
     * @param userId
     * @return
     */
    @RequestMapping("/selectGoodsList")
    public List<ShoppingCartDao> selectGoodsList(Integer userId, HttpServletRequest request) {
        if (userId == null || userId == 0) {
            userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        }
        return shoppingCartService.selectGoodsList(userId);
    }

    /**
     * 删除购物车中某件商品
     *
     * @param paramsDto
     * @return
     */
    @RequestMapping("/delete")
    public Integer delete(ShoppingCartParamsDto paramsDto, HttpServletRequest request) {
        if (paramsDto.getTbUserId() == null || paramsDto.getTbUserId() == 0) {
            paramsDto.setTbUserId(SessionUtil.getInstance().getUserId(request.getSession().getId()));
        }
        StoreEntity store = storeService.getByGoodsId(paramsDto.getTbGoodsId());
        if (store != null) {
            store.setCount(store.getCount() + paramsDto.getCount());
            storeService.update(store);
        }
        return shoppingCartService.delete(paramsDto);
    }

    /**
     * 修改数目
     *
     * @param paramsDto
     * @return
     */
    @RequestMapping("updateCount")
    public Integer updateCount(ShoppingCartParamsDto paramsDto, HttpServletRequest request) {
        if (paramsDto.getTbUserId() == null || paramsDto.getTbUserId() == 0) {
            paramsDto.setTbUserId(SessionUtil.getInstance().getUserId(request.getSession().getId()));
        }
        ShoppingCartEntity cart = shoppingCartService.getById(paramsDto.getTbUserId(), paramsDto.getTbGoodsId());
        if (cart != null) {
            StoreEntity store = storeService.getByGoodsId(cart.getTbGoodsId());
            if (store != null) {
                store.setCount(store.getCount() + (cart.getCount() - paramsDto.getCount()));
                storeService.update(store);
            }
        }
        return shoppingCartService.updateCount(paramsDto);
    }

    /**
     * 添加商品到购物车，如果已存在这条数据，则更新它（常用于修改购物车中商品数量）
     *
     * @param shoppingCartEntity
     * @return
     */
    @RequestMapping("/saveOrUpdate")
    public Integer saveOrUpdate(ShoppingCartEntity shoppingCartEntity, HttpServletRequest request) {
        if (shoppingCartEntity.getTbUserId() == null || shoppingCartEntity.getTbUserId() == 0) {
            shoppingCartEntity.setTbUserId(SessionUtil.getInstance().getUserId(request.getSession().getId()));
        }
        StoreEntity store = storeService.getByGoodsId(shoppingCartEntity.getTbGoodsId());
        if (store != null) {
            store.setCount(store.getCount() + shoppingCartEntity.getCount());
            storeService.update(store);
        }
        return shoppingCartService.saveOrUpdate(shoppingCartEntity);
    }

    /**
     * 购买全部商品
     *
     * @param userId
     * @param realSum
     * @return
     */
    @RequestMapping("/buyAllGoods")
    public Integer buyAllGoods(Integer userId, Double realSum, HttpServletRequest request) {
        if (userId == null || userId == 0) {
            userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        }
        return shoppingCartService.buyAllGoods(userId, realSum);
    }

}
