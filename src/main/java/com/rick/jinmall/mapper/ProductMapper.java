package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.product.ProductCategory;

import java.util.List;

public interface ProductMapper {

    void addProductType(ProductCategory productCategory);

    ProductCategory getProductTypeById(int id);

    List<ProductCategory> getProductType();

    void updateProductTypeById(ProductCategory productCategory);
}
