package com.rick.jinmall.service;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderVo;

import java.util.List;

public interface OrderService {

    void addOrder(Order order);

    List<Order> orderList(OrderVo orderVo);

    void updateOrderByUser(int id, String receiverName, String receiverPhone, String receiverAddress);

    Order getOrderById(int id);

    void deleteOrderById(int id);

    void updateOrderById(Order order);

}
