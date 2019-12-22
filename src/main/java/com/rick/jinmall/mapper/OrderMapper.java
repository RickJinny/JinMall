package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderVo;

import java.util.List;

public interface OrderMapper {

    void addOrder(Order order);

    List<Order> orderList(OrderVo orderVo);

    void updateOrderByUser(Order order);

    Order getOrderById(int id);

    void deleteOrderById(int id);

    void updateOrderById(Order order);
}
