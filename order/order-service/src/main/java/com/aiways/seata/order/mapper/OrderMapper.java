package com.aiways.seata.order.mapper;

import com.aiways.seata.order.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 21:54
 */
public interface OrderMapper {

    @Insert("insert into tb_order (detail,total_fee) values(#{detail},#{totalFee})")
    Integer saveOrder(@Param("detail") String detail, @Param("totalFee") Long totalFee);

    @Select("select * from tb_order where id=#{id}")
    Order getOrder(@Param("id") String id);

    @Select("select * from tb_order")
    List<Order> listOrder();

    @Delete("delete from tb_order  where id=#{orderId}")
    Integer deleteOrder(@Param("orderId") Integer orderId);
}
