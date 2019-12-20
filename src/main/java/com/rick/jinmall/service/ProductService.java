package com.rick.jinmall.service;

import com.rick.jinmall.bean.product.ProductType;

import java.util.List;

public interface ProductService {

    void addProductType(ProductType productType);

    ProductType getProductTypeById(int id);

    List<ProductType> getProductType();

    void updateProductTypeById(ProductType productType);
}
