package com.rick.jinmall.service;

import com.rick.jinmall.bean.product.ProductDetail;

public interface ProductDetailService {

    int addProductDetail(ProductDetail productDetail);

    ProductDetail getProductDetailById(int productId);
}
