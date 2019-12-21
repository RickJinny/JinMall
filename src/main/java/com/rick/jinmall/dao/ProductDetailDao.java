package com.rick.jinmall.dao;

import com.rick.jinmall.bean.product.ProductDetail;
import com.rick.jinmall.mapper.ProductDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDetailDao {

    @Autowired
    private ProductDetailMapper productDetailMapper;

    public int addProductDetail(ProductDetail productDetail) {
        return productDetailMapper.addProductDetail(productDetail);
    }

    public ProductDetail getProductDetailById(int productId) {
        return productDetailMapper.getProductDetailById(productId);
    }
}
