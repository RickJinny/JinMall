package com.rick.jinmall.bean.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCategory {
    /**
     * id
     */
    private Long id;
    /**
     * 商品类型名称
     */
    private String productTypeName;
    /**
     * 商品描述
     */
    private String productTypeDesc;
    /**
     * 商品类型等级
     */
    private Integer productTypeLevel;
    /**
     * 父类型id
     */
    private Integer parentId;
}
