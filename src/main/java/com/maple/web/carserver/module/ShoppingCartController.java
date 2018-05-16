package com.maple.web.carserver.module;

import com.maple.web.carserver.dao.ShoppingCartDao;
import com.maple.web.carserver.dao.ShoppingCartParamsDto;
import com.maple.web.carserver.domain.IndentEntity;
import com.maple.web.carserver.domain.ShoppingCartEntity;
import com.maple.web.carserver.domain.StoreEntity;
import com.maple.web.carserver.domain.UserEntity;
import com.maple.web.carserver.service.IndentService;
import com.maple.web.carserver.service.ShoppingCartService;
import com.maple.web.carserver.service.StoreService;
import com.maple.web.carserver.service.UserService;
import com.maple.web.carserver.utils.SessionUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("shoppingCart")
public class ShoppingCartController {

    @Resource
    private ShoppingCartService shoppingCartService;
    @Resource
    private StoreService storeService;
    @Resource
    private UserService userService;
    @Resource
    private IndentService indentService;

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
     * @param goodsId
     * @return
     */
    @RequestMapping("/delete")
    public Integer delete(HttpServletRequest request, Integer goodsId) {
        Integer userId = SessionUtil.getInstance().getUserId(request.getSession().getId());
        if (goodsId == null || goodsId == 0 || userId == null || userId == 0) {
            return -1;
        }
        ShoppingCartEntity cart = shoppingCartService.getById(userId, goodsId);
        StoreEntity store = storeService.getByGoodsId(goodsId);
        if (store != null && cart != null) {
            store.setCount(store.getCount() + cart.getCount());
            storeService.update(store);
        }

        return shoppingCartService.delete(cart.getId());
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
            store.setCount(store.getCount() - shoppingCartEntity.getCount());
            storeService.update(store);
        }
        return shoppingCartService.saveOrUpdate(shoppingCartEntity);
    }


    @RequestMapping("/buyAllGoods")
    public Integer buyAllGoods(HttpServletRequest request, IndentEntity indent) {
        UserEntity user;
        if (indent.getUserId() == null) {
            indent.setUserId(SessionUtil.getInstance().getUserId(request.getSession().getId()));
        }
        user = userService.getUserById(indent.getUserId());
        if (user == null) {
            return -1;
        }

        List<ShoppingCartDao> goodsList = shoppingCartService.selectGoodsList(indent.getUserId());
        double total = 0;
        double pay = 0;
        for (ShoppingCartDao goods : goodsList) {
            total = total + goods.getPrice() * goods.getCount();
            pay = pay + goods.getPrice() * goods.getCount() * goods.getDiscount() / 100D;
        }

        //余额或积分不足
        if (user.getBalance() < indent.getMoney() || user.getIntegral() < indent.getIntegral()) {
            return -1;
        }

        String cartIdList = goodsList.stream().map(g -> g.getCartId().toString()).collect(Collectors.joining(","));

        //更新购物车商品状态
        shoppingCartService.buyAllGoods(cartIdList.split(","));

        //生成订单信息
        indent.setCartId(String.join(",", cartIdList));
        indent.setStatus(0);
        indent.setTotal(total); //商品总金额
        indent.setPay(pay); //折后总金额
        indent.setCreateTime(new Date());
        indentService.insert(indent);

        //扣除账户中的钱款和积分
        user.setBalance(user.getBalance() - indent.getMoney());
        user.setIntegral(user.getIntegral() - indent.getIntegral());
        userService.updateAccount(user);
        return 1;
    }
}
