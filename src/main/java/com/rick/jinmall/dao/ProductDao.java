package com.rick.jinmall.dao;

import com.rick.jinmall.bean.product.Product;
import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.bean.product.ProductVo;
import com.rick.jinmall.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public int addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    public void auditProduct(Product product) {
        productMapper.auditProduct(product);
    }

    public Product getProductById(int id) {
        return productMapper.getProductById(id);
    }

    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    public void deleteProductById(int id) {
        productMapper.deleteProductTypeById(id);
    }

    public List<Product> queryProductByVo(ProductVo productVo) {
        return productMapper.queryProductByVo(productVo);
    }

    public void updateProductByStatus(Product product) {
        productMapper.updateProductByStatus(product);
    }

    public List<Product> queryProductByIds(List<String> ids) {
        Map<String, List<String>> map = new HashMap<>();
        map.put("ids", ids);
        return productMapper.queryProductByIds(map);
    }
}
