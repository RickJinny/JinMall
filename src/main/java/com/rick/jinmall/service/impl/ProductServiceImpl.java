package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.dao.ProductDao;
import com.rick.jinmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public void addProductType(ProductType productType) {
        productDao.addProductType(productType);
    }

    @Override
    public ProductType getProductTypeById(int id){
        return productDao.getProductTypeById(id);
    }

    @Override
    public List<ProductType> getProductType(){
        return productDao.getProductType();
    }

    @Override
    public void updateProductTypeById(ProductType productType){
        productDao.updateProductTypeById(productType);
    }

    @Override
    public List<ProductType> queryListByProductVo(ProductTypeVo productTypeVo) {
        return productDao.queryListByProductVo(productTypeVo);
    }

    @Override
    public void deleteProductTypeById(int id) {
        productDao.deleteProductTypeById(id);
    }
}
