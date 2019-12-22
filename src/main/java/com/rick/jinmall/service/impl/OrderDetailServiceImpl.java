package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.order.OrderDetail;
import com.rick.jinmall.dao.OrderDetailDao;
import com.rick.jinmall.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Override
    public void addOrderDetail(OrderDetail orderDetail) {
        orderDetailDao.addOrderDetail(orderDetail);
    }
}
