package com.aiways.seata.order.controller;

import com.aiways.seata.order.pojo.Cart;
import com.aiways.seata.order.pojo.Order;
import com.aiways.seata.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wujing
 * @date 2020/4/24 21:40
 */
@RestController
@RequestMapping("/order")
@EnableFeignClients
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 使用GlobalTransactional保存订单
     *
     * @param cartList
     * @return
     */
    @PostMapping("/enableGlobalTransactional")
    public ResponseEntity<Void> enableGlobalTransactional(@RequestBody List<Cart> cartList) {

        orderService.enableGlobalTransactional(cartList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 使用Transactional保存订单
     *
     * @param cartList
     * @return
     */
    @PostMapping("/enableTransactional")
    public ResponseEntity<Void> enableTransactional(@RequestBody List<Cart> cartList) {

        orderService.enableTransactional(cartList);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    /**
     * 获取订单信息
     *
     * @param id
     * @return
     */
    @GetMapping("/getOrder/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") String id) {

        return ResponseEntity.ok(orderService.getOrder(id));
    }

    /**
     * 获取所有订单信息
     *
     * @return
     */
    @PostMapping("/listOrder")
    public ResponseEntity<List<Order>> listOrder() {

        return ResponseEntity.ok(orderService.listOrder());
    }

    /**
     * 切换保存订单时运行的状态
     *
     * @param toggleFlag
     * @return
     */
    @PostMapping("/toggleStatus/{toggleFlag}")
    public ResponseEntity<Void> toggleStatus(@PathVariable("toggleFlag") Boolean toggleFlag) {

        orderService.toggleStatus(toggleFlag);
        return ResponseEntity.ok().build();
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */
    @DeleteMapping("/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") Integer orderId) {

        orderService.deleteOrder(orderId);
        return ResponseEntity.ok().build();
    }


//    @PostMapping("/toggleTransaction")
//    public ResponseEntity<Void> toggleTransaction() {
//
//        orderService.toggleTransaction();
//        return ResponseEntity.ok().build();
//    }
//
//    @PostMapping("/restart")
//    public ResponseEntity<Void> restart() {
//
//        orderService.restart();
//        return ResponseEntity.ok().build();
//    }
}
