package com.rick.jinmall.controller;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderVo;
import com.rick.jinmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/addOrder")
    @ResponseBody
    public void addOrder(Order order) {
        orderService.addOrder(order);
    }

    @RequestMapping(value = "/orderList")
    @ResponseBody
    public List<Order> orderList(OrderVo orderVo) {
        return orderService.orderList(orderVo);
    }

    @RequestMapping(value = "/updateOrderByUser")
    @ResponseBody
    public void updateOrderByUser(int id, String receiverName, String receiverPhone,
                                  String receiverAddress) {
        orderService.updateOrderByUser(id, receiverName, receiverPhone, receiverAddress);
    }

    @RequestMapping(value = "/getOrderById")
    @ResponseBody
    public Order getOrderById(int id) {
        return orderService.getOrderById(id);
    }

    @RequestMapping(value = "/deleteOrderById")
    @ResponseBody
    public void deleteOrderById(int id) {
        orderService.deleteOrderById(id);
    }

    @RequestMapping(value = "/updateOrderById")
    @ResponseBody
    public void updateOrderById(Order order) {
        orderService.updateOrderById(order);
    }
}
