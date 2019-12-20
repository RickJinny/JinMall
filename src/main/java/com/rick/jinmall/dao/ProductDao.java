package com.rick.jinmall.dao;

import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDao {

    @Autowired
    private ProductMapper productMapper;

    public void addProductType(ProductType productType) {
        productMapper.addProductType(productType);
    }

    public ProductType getProductTypeById(int id){
        return productMapper.getProductTypeById(id);
    }

    public List<ProductType> getProductType(){
        return productMapper.getProductType();
    }

    public void updateProductTypeById(ProductType productType){
        productMapper.updateProductTypeById(productType);
    }

    public List<ProductType> queryListByProductVo(ProductTypeVo productTypeVo) {
        return productMapper.queryListByProductVo(productTypeVo);
    }

    public void deleteProductTypeById(int id) {
        productMapper.deleteProductTypeById(id);
    }
}
