package com.rick.jinmall.service;

import com.rick.jinmall.bean.product.Product;
import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.bean.product.ProductVo;

import java.util.List;

public interface ProductService {

    void addProductType(ProductType productType);

    ProductType getProductTypeById(int id);

    List<ProductType> getProductType();

    void updateProductTypeById(ProductType productType);

    List<ProductType> queryListByProductVo(ProductTypeVo productTypeVo);

    void deleteProductTypeById(int id);

    void addProduct(Product product);

    void auditProduct(Product product);

    Product getProductById(int id);

    void updateProduct(Product product);

    void deleteProductById(int id);

    List<Product> queryProductByVo(ProductVo productVo);

    void updateProductByStatus(Product product);

    List<Product> queryProductByIds(List<String> ids);
}
