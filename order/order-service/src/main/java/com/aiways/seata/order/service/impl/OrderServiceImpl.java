package com.aiways.seata.order.service.impl;

import com.aiways.seata.common.util.JsonUtils;
import com.aiways.seata.goods.api.GoodsApi;
import com.aiways.seata.goods.pojo.Goods;
import com.aiways.seata.order.mapper.OrderMapper;
import com.aiways.seata.order.pojo.Cart;
import com.aiways.seata.order.pojo.Order;
import com.aiways.seata.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 22:52
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

//    @Autowired
//    private ApplicationContext applicationContext;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private GoodsApi goodsApi;

    //除数
    private volatile int divisor = 0;

    @Override
    @GlobalTransactional(rollbackFor = ArithmeticException.class)
    public void enableGlobalTransactional(List<Cart> cartList) {

        saveOrder(cartList);
    }


    @Override
    @Transactional(rollbackFor = ArithmeticException.class)
    public void enableTransactional(List<Cart> cartList) {

        saveOrder(cartList);
    }


    private void saveOrder(List<Cart> cartList) {

        HashMap<Goods, Integer> goodsMap = new HashMap<>(3);
        long totalFee = 0;
        for (int i = 0; i < cartList.size(); i++) {

            // 获取购物车信息
            Cart cart = cartList.get(i);
            Integer goodsId = cart.getGoodsId();
            Integer goodsNum = cart.getGoodsNum();

            //减少商品库存
            goodsApi.minusStock(goodsId, goodsNum);

            //获取商品信息
            Goods goods = goodsApi.getGoods(goodsId);
            goodsMap.put(goods, goodsNum);
            totalFee += goods.getFee() * goodsNum;
        }

        //保存订单信息
        int var = 1 / divisor;
        orderMapper.saveOrder(JsonUtils.toString(goodsMap), totalFee);
    }

    @Override
    public Order getOrder(String id) {

        return orderMapper.getOrder(id);
    }

    @Override
    public void toggleStatus(Boolean toggleFlag) {

        divisor = toggleFlag
                ? 0
                : 1;
    }

    @Override
    public List<Order> listOrder() {

        List<Order> orders = orderMapper.listOrder();
        return orders;
    }

    @Override
    public void deleteOrder(Integer orderId) {

        orderMapper.deleteOrder(orderId);
    }


//    public void toggleTransaction() {
//
//        BeanDefinition beanDefinition = ((AnnotationConfigApplicationContext) applicationContext).getBeanDefinition("orderService");
//        Class<?> beanClass = ((GenericBeanDefinition) beanDefinition).getBeanClass();
//        for (Method method : beanClass.getMethods()) {
//
//            if (method.isAnnotationPresent(GlobalTransactional.class)) {
//
//                GlobalTransactional globalTransactional = method.getAnnotation(GlobalTransactional.class);
//                InvocationHandler invocationHandler = Proxy.getInvocationHandler(globalTransactional);
//                try {
//
//                    // 获取 AnnotationInvocationHandler 的 memberValues 字段
//                    Field hField = invocationHandler.getClass().getDeclaredField("memberValues");
//
//                    // 因为这个字段 private final 修饰，所以要打开权限
//                    hField.setAccessible(true);
//
//                    // 获取 memberValues
//                    Map memberValues = (Map) hField.get(invocationHandler);
//
//                    // 修改 value 属性值
//                    memberValues.put("value", "ddd");
//                } catch (Exception e) {
//
//                    log.warn("------------------>代理失败");
//                }
//                // 获取 foo 的 value 属性值
//                Class<? extends Throwable>[] exceptionClass = globalTransactional.rollbackFor();
//                log.info("------------------> {}", exceptionClass);
//
//            }
//        }
//    }

//    public void restart() {
//
//        ApplicationArguments applicationArguments = applicationContext.getBean(ApplicationArguments.class);
//
//        Thread thread = new Thread(() -> {
//
//            ((ConfigurableApplicationContext) applicationContext).close();
//            applicationContext = SpringApplication.run(Application.class, applicationArguments.getSourceArgs());
//        });
//
//        thread.setDaemon(false);
//        thread.start();
//    }
}
