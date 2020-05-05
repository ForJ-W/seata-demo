package com.aiways.seata.goods.controller;

import com.aiways.seata.goods.pojo.Goods;
import com.aiways.seata.goods.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 21:41
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 减商品库存
     *
     * @param id
     * @param num
     * @return
     */
    @PostMapping("/minusStock/{id}/{num}")
    public ResponseEntity<Void> minusStock(@PathVariable("id") Integer id,
                                           @PathVariable("num") Integer num) {

        goodsService.minusStock(num, id);
        return ResponseEntity.ok().build();
    }

    /**
     * 获取商品
     *
     * @param id
     * @return
     */
    @PostMapping("/getGoods/{id}")
    public ResponseEntity<Goods> getGoods(@PathVariable("id") Integer id) {

        return ResponseEntity.ok(goodsService.getGoods(id));
    }

    /**
     * 获取所有商品
     *
     * @return
     */
    @PostMapping("/listGoods")
    public ResponseEntity<List<Goods>> listGoods() {

        return ResponseEntity.ok(goodsService.listGoods());
    }

    /**
     * 修改商品
     *
     * @param goods
     * @return
     */
    @PostMapping("/updateGoods")
    public ResponseEntity<Void> updateGoods(@RequestBody Goods goods) {

        goodsService.updateGoods(goods);
        return ResponseEntity.ok().build();
    }
}
