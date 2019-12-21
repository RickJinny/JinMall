package com.rick.jinmall.bean.product;

import lombok.Data;

@Data
public class Product {

    // 商品id
    private Long id;

    // 商品类型id
    private Integer productTypeId;

    // 商品名称
    private String productName;

    // 商品价格
    private Long productPrice;

    // 商家id
    private Integer merchantId;

    // 创建时间
    private String createTime;

    // 更新时间
    private String updateTime;

    // 审核时间
    private String auditTime;

    // 审核状态
    private Integer auditStatus;

    // 库存数量
    private Long stockNum;

    // 销售数量
    private Long sellNum;

    // 商品图片
    private String productImg;
}
