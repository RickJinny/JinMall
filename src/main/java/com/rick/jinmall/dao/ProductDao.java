package com.rick.jinmall.dao;

import com.rick.jinmall.bean.product.ProductCategory;
import com.rick.jinmall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    public void addProductType(ProductCategory productCategory) {
        productMapper.addProductType(productCategory);
    }

    public ProductCategory getProductTypeById(int id){
        return productMapper.getProductTypeById(id);
    }

    public List<ProductCategory> getProductType(){
        return productMapper.getProductType();
    }

    public void updateProductTypeById(ProductCategory productCategory){
        productMapper.updateProductTypeById(productCategory);
    }
}
