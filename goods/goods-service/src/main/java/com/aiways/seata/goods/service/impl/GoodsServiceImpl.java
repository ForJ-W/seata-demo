package com.aiways.seata.goods.service.impl;

import com.aiways.seata.goods.mapper.GoodsMapper;
import com.aiways.seata.goods.pojo.Goods;
import com.aiways.seata.goods.service.GoodsService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 22:52
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public void minusStock(Integer num, Integer id) {

        goodsMapper.minusStock(num, id);
    }

    @Override
//    @GlobalTransactional
    public Goods getGoods(Integer id) {

        return goodsMapper.getGoods(id);
    }

    @Override
    public List<Goods> listGoods() {

        return goodsMapper.listGoods();
    }

    @Override
//    @GlobalTransactional
    public void updateGoods(Goods goods) {

        goodsMapper.updateGoods(goods);
    }
}
