package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.product.Product;
import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.bean.product.ProductVo;
import com.rick.jinmall.dao.ProductDao;
import com.rick.jinmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public void addProduct(Product product) {
        try {
            int id = productDao.addProduct(product);
            Map<String, Object> map = new HashMap<>();
            map.put("id", product.getId());
            map.put("productName", product.getProductName());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void auditProduct(Product product) {

    }

    @Override
    public Product getProductById(int id) {
        return null;
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public void deleteProductById(int id) {

    }

    @Override
    public List<Product> queryProductByVo(ProductVo productVo) {
        return null;
    }

    @Override
    public void updateProductByStatus(Product product) {

    }

    @Override
    public List<Product> queryProductByIds(List<String> ids) {
        return null;
    }
}
