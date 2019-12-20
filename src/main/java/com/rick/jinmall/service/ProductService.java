package com.rick.jinmall.service;

import com.rick.jinmall.bean.product.ProductCategory;

import java.util.List;

public interface ProductService {

    void addProductType(ProductCategory productCategory);

    ProductCategory getProductTypeById(int id);

    List<ProductCategory> getProductType();

    void updateProductTypeById(ProductCategory productCategory);
}
