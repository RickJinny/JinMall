package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.order.Order;
import com.rick.jinmall.bean.order.OrderVo;
import com.rick.jinmall.dao.OrderDao;
import com.rick.jinmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public void addOrder(Order order) {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateString = dateFormat.format(date);
        // 交易流水号：UUID + 时间戳
        String tradeNumber = UUID.randomUUID() + dateString;
        order.setCreateTime(date);
        order.setUpdateTime(date);
        order.setTradeNumber(tradeNumber);
        order.setOrderStatus(0);
        order.setPayStatus(1);
        orderDao.addOrder(order);
    }

    @Override
    public List<Order> orderList(OrderVo orderVo) {
        return orderDao.orderList(orderVo);
    }

    @Override
    public void updateOrderByUser(int id, String receiverName,
                                  String receiverPhone, String receiverAddress) {
        Order order = new Order();
        order.setId(id);
        order.setReceiverName(receiverName);
        order.setReceiverPhone(receiverPhone);
        order.setReceiverAddress(receiverAddress);
        orderDao.updateOrderByUser(order);
    }

    @Override
    public Order getOrderById(int id) {
        return orderDao.getOrderById(id);
    }

    @Override
    public void deleteOrderById(int id) {
        orderDao.deleteOrderById(id);
    }

    @Override
    public void updateOrderById(Order order) {
        order.setPayTime(new Date());
        orderDao.updateOrderById(order);
    }
}
