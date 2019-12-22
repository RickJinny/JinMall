package com.rick.jinmall.dao;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderVo;
import com.rick.jinmall.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    public List<Order> orderList(OrderVo orderVo) {
        return orderMapper.orderList(orderVo);
    }

    public void updateOrderByUser(Order order) {
        orderMapper.updateOrderByUser(order);
    }

    public Order getOrderById(int id) {
        return orderMapper.getOrderById(id);
    }

    public void deleteOrderById(int id) {
        orderMapper.deleteOrderById(id);
    }

    public void updateOrderById(Order order) {
        orderMapper.updateOrderById(order);
    }
}
