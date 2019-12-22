package com.rick.jinmall.bean.order;

import lombok.Data;

@Data
public class OrderAll {

    private Order order;

    private OrderDetail orderDetail;
}
