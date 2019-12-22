package com.rick.jinmall.bean.order;

import lombok.Data;

import java.util.Date;

/**
 * 订单信息
 */
@Data
public class Order {
    // id
    private Integer id;
    // 用户id
    private Long userId;
    // 支付金额
    private Long payAmount;
    // 创建时间
    private Date createTime;
    // 更新时间
    private Date updateTime;
    // 支付时间
    private Date payTime;
    // 支付状态
    private Integer payStatus;
    // 收货人地址
    private String receiverAddress;
    // 收货人电话
    private String receiverPhone;
    // 收货人姓名
    private String receiverName;
    // 交易流水号
    private String tradeNumber;
    // 支付类型
    private Integer payType;
    // 订单状态
    private Integer orderStatus;
}
