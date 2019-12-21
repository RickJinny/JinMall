package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.product.ProductDetail;

public interface ProductDetailMapper {

    int addProductDetail(ProductDetail productDetail);

    ProductDetail getProductDetailById(int productId);
}
