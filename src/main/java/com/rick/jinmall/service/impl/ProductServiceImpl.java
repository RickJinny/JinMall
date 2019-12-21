package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.product.Product;
import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.bean.product.ProductVo;
import com.rick.jinmall.dao.ProductDao;
import com.rick.jinmall.service.ProductService;
import com.rick.jinmall.utils.SolrUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SolrClient solrClient;

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
            SolrUtil.addIndex(solrClient, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void auditProduct(int id, int auditStatus) {
        Product product = new Product();
        product.setId(id);
        product.setAuditStatus(auditStatus);
        product.setAuditTime(new Date());
        productDao.auditProduct(product);
    }

    @Override
    public Product getProductById(int id) {
        return productDao.getProductById(id);
    }

    @Override
    public void updateProduct(Product product) {
        productDao.updateProduct(product);
    }

    @Override
    public void deleteProductById(int id) {
        productDao.deleteProductById(id);
    }

    @Override
    public List<Product> queryProductByVo(ProductVo productVo) {
        return productDao.queryProductByVo(productVo);
    }

    @Override
    public void updateProductByStatus(int id, int auditStatus) {
        Product product = new Product();
        product.setId(id);
        product.setAuditStatus(auditStatus);
        productDao.updateProductByStatus(product);
    }

    @Override
    public List<Product> queryProductByIds(String keyWord) {
        List<String> ids = null;
        try {
            ids = SolrUtil.searchInfoFromSolr(solrClient, keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (ids == null || ids.size() == 0) {
            ids = null;
        }

        return productDao.queryProductByIds(ids);
    }
}
