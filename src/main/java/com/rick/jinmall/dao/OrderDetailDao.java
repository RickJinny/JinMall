package com.rick.jinmall.dao;

import com.rick.jinmall.bean.order.OrderDetail;
import com.rick.jinmall.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailDao {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailMapper.addOrderDetail(orderDetail);
    }
}
