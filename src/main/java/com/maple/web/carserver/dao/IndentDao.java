package com.maple.web.carserver.dao;

import com.maple.web.carserver.domain.IndentEntity;

import java.util.List;

/**
 * Created by mogu
 * Date: 2018/5/15
 */
public class IndentDao extends IndentEntity {
    private List<ShoppingCartDao> cartDetail;

    public List<ShoppingCartDao> getCartDetail() {
        return cartDetail;
    }

    public void setCartDetail(List<ShoppingCartDao> cartDetail) {
        this.cartDetail = cartDetail;
    }
}
