package com.rick.jinmall.bean.order;

import lombok.Data;

import java.util.Date;

@Data
public class OrderDetail {
    // id
    private Long id;
    // 订单id
    private Integer orderId;
    // 商品id
    private Long productId;
    // 商家id
    private Long merchantId;
    // 交易数量
    private Long tradeNum;
    // 创建时间
    private Date createTime;
}
