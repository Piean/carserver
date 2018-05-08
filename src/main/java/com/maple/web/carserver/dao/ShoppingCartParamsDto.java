package com.maple.web.carserver.dao;

import com.maple.web.carserver.domain.ShoppingCartEntity;

/**
 * 用于添加购物车
 */
public class ShoppingCartParamsDto {

    private Integer tbUserId;
    private Integer tbGoodsId;
    private Integer count;

    public Integer getTbUserId() {
        return tbUserId;
    }

    public void setTbUserId(Integer tbUserId) {
        this.tbUserId = tbUserId;
    }

    public Integer getTbGoodsId() {
        return tbGoodsId;
    }

    public void setTbGoodsId(Integer tbGoodsId) {
        this.tbGoodsId = tbGoodsId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public ShoppingCartEntity toEntity(){
        ShoppingCartEntity entity = new ShoppingCartEntity();
        entity.setCount(count);
        entity.setTbUserId(tbUserId);
        entity.setTbGoodsId(tbGoodsId);
        return entity;
    }
}
