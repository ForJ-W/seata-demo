package com.aiways.seata.goods.service;

import com.aiways.seata.goods.pojo.Goods;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 22:52
 */
public interface GoodsService {

    /**
     * 减商品库存
     * @param num
     * @param id
     */
    void minusStock(Integer num, Integer id);

    /**
     * 获取商品
     * @param id
     * @return
     */
    Goods getGoods(Integer id);

    /**
     * 获取所有商品
     * @return
     */
    List<Goods> listGoods();

    /**
     * 修改商品
     * @param goods
     */
    void updateGoods(Goods goods);
}
