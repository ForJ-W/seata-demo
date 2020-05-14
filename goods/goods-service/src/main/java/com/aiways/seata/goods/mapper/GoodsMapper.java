package com.aiways.seata.goods.mapper;

import com.aiways.seata.goods.pojo.Goods;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 21:55
 */
public interface GoodsMapper {
    @Update("update tb_goods set stock = stock - #{num} where id = #{id}")
    Integer minusStock(@Param("num") Integer num, @Param("id") Integer id);

    @Select("select * from tb_goods where id=#{id} for update")
    Goods getGoods(@Param("id") Integer id);

    @Select("select * from tb_goods")
    List<Goods> listGoods();

    @Update("update tb_goods set name=#{name}, fee=#{fee}, stock = #{stock} where id = #{id}")
    Integer updateGoods(Goods goods);
}
