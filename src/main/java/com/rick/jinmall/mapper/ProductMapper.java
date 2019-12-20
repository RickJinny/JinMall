package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;

import java.util.List;

public interface ProductMapper {

    void addProductType(ProductType productType);

    ProductType getProductTypeById(int id);

    List<ProductType> getProductType();

    void updateProductTypeById(ProductType productType);

    List<ProductType> queryListByProductVo(ProductTypeVo productTypeVo);

    void deleteProductTypeById(int id);
}
