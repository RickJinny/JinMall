package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.product.ProductType;

import java.util.List;

public interface ProductMapper {

    void addProductType(ProductType productType);

    ProductType getProductTypeById(int id);

    List<ProductType> getProductType();

    void updateProductTypeById(ProductType productType);
}
