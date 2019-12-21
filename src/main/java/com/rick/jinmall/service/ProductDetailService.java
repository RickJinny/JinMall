package com.rick.jinmall.service;

import com.rick.jinmall.bean.product.ProductDetail;

public interface ProductDetailService {

    void addProductDetail(ProductDetail productDetail);

    ProductDetail getProductDetailById(int productId);
}
