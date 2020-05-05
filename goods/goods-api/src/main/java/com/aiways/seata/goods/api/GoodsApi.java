package com.aiways.seata.goods.api;

import com.aiways.seata.goods.pojo.Goods;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author wujing
 * @date 2020/4/25 0:01
 */
@FeignClient("goods-service")
public interface GoodsApi {

    /**
     * 减商品库存
     *
     * @param id
     * @param num
     */
    @PostMapping("/goods/minusStock/{id}/{num}")
    void minusStock(@PathVariable("id") Integer id,
                    @PathVariable("num") Integer num);

    /**
     * 获取商品
     *
     * @param id
     * @return
     */
    @PostMapping("/goods/getGoods/{id}")
    Goods getGoods(@PathVariable("id") Integer id);
}
