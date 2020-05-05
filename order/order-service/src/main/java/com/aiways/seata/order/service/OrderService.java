package com.aiways.seata.order.service;

import com.aiways.seata.order.pojo.Cart;
import com.aiways.seata.order.pojo.Order;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 22:52
 */
public interface OrderService {

    /**
     * 使用GlobalTransactional保存订单
     *
     * @param cartList
     */
    void enableGlobalTransactional(List<Cart> cartList);

    /**
     * 使用Transactional保存订单
     *
     * @param cartList
     */
    void enableTransactional(List<Cart> cartList);

    /**
     * 获取订单信息
     *
     * @param id
     * @return
     */
    Order getOrder(String id);

    /**
     * 切换保存订单时运行的状态
     *
     * @param toggleFlag
     */
    void toggleStatus(Boolean toggleFlag);

    /**
     * 获取所有订单信息
     *
     * @return
     */
    List<Order> listOrder();

    /**
     * 删除订单
     *
     * @param orderId
     */
    void deleteOrder(Integer orderId);

}
