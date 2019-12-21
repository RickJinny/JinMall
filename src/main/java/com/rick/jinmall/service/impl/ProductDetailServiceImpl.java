package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.product.ProductDetail;
import com.rick.jinmall.dao.ProductDetailDao;
import com.rick.jinmall.service.ProductDetailService;
import com.rick.jinmall.utils.SolrUtil;
import org.apache.solr.client.solrj.SolrClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductDetailServiceImpl implements ProductDetailService {

    @Autowired
    private ProductDetailDao productDetailDao;

    @Autowired
    private SolrClient solrClient;

    @Override
    public void addProductDetail(ProductDetail productDetail) {
        try {
            int id = productDetailDao.addProductDetail(productDetail);
            Map<String, Object> map = new HashMap<>();
            map.put("id", productDetail.getProductId());
            map.put("productName", productDetail.getProductName());
            SolrUtil.addIndex(solrClient, map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public ProductDetail getProductDetailById(int productId) {
        return productDetailDao.getProductDetailById(productId);
    }
}
