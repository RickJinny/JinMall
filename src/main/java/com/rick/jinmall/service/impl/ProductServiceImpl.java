package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.product.ProductCategory;
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
    public void addProductType(ProductCategory productCategory) {
        productDao.addProductType(productCategory);
    }

    @Override
    public ProductCategory getProductTypeById(int id){
        return productDao.getProductTypeById(id);
    }

    @Override
    public List<ProductCategory> getProductType(){
        return productDao.getProductType();
    }

    @Override
    public void updateProductTypeById(ProductCategory productCategory){
        productDao.updateProductTypeById(productCategory);
    }
}
