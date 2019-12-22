package com.rick.jinmall.controller;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderVo;
import com.rick.jinmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    public List<Order> orderList(OrderVo orderVo) {
        return orderService.orderList(orderVo);
    }

    public void updateOrderByUser(int id, String receiverName, String receiverPhone,
                                  String receiverAddress) {
        orderService.updateOrderByUser(id, receiverName, receiverPhone, receiverAddress);
    }

    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }

    public void deleteOrderById(int id) {
        orderService.deleteOrderById(id);
    }

    public void updateOrderById(Order order) {
        orderService.updateOrderById(order);
    }
}
