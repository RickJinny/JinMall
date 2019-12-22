package com.rick.jinmall.controller;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderAll;
import com.rick.jinmall.bean.order.OrderDetail;
import com.rick.jinmall.service.OrderDetailService;
import com.rick.jinmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/orderDetail")
public class OrderDetailController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/addOrder")
    @ResponseBody
    public Integer addOrder(@RequestBody OrderAll orderAll) {
        Order order = orderAll.getOrder();
        OrderDetail orderDetail = orderAll.getOrderDetail();
        orderService.addOrder(order);
        orderDetail.setCreateTime(order.getCreateTime());
        orderDetail.setOrderId(order.getId());
        orderDetailService.addOrderDetail(orderDetail);
        return order.getId();
    }

    @RequestMapping(value = "/getOrderById")
    @ResponseBody
    public Order getOrderById(@RequestParam int id) {
        Order order = orderService.getOrderById(id);
        return order;
    }

    @RequestMapping(value = "/updateOrderStatusById")
    @ResponseBody
    public void updateOrderStatusById(@RequestParam int id, @RequestParam int payType,
                                      @RequestParam int payStatus) {
        Order order = new Order();
        order.setId(id);
        order.setPayType(payType);
        order.setPayStatus(payStatus);
        orderService.updateOrderById(order);
    }
}
