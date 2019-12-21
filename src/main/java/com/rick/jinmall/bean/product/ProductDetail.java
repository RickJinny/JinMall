package com.rick.jinmall.bean.product;

import lombok.Data;

@Data
public class ProductDetail {
    // id
    private Long id;
    // 商品id
    private Long productId;
    // 商品产地
    private String productPlace;
    // 商品名称
    private String productName;
    // 商品品牌
    private String productBrand;
    // 商品重量
    private String productWeight;
    // 商品规格和包装
    private String productSpecification;
    // 商品详情图片地址
    private String productDetailImg;
}
