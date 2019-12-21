package com.rick.jinmall.controller;

import com.rick.jinmall.bean.product.Product;
import com.rick.jinmall.bean.product.ProductType;
import com.rick.jinmall.bean.product.ProductTypeVo;
import com.rick.jinmall.bean.product.ProductVo;
import com.rick.jinmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addProductType")
    @ResponseBody
    public void addProductType(ProductType productType) {
        productService.addProductType(productType);
    }

    @RequestMapping(value = "/getProductTypeById")
    @ResponseBody
    public ProductType getProductTypeById(int id){
        return productService.getProductTypeById(id);
    }

    @RequestMapping(value = "/getProductType")
    @ResponseBody
    public List<ProductType> getProductType(){
        return productService.getProductType();
    }

    @RequestMapping(value = "/updateProductTypeById")
    @ResponseBody
    public void updateProductTypeById(ProductType productType){
        productService.updateProductTypeById(productType);
    }

    @RequestMapping(value = "/queryListByProductVo")
    @ResponseBody
    public List<ProductType> queryListByProductVo(ProductTypeVo productTypeVo) {
        return productService.queryListByProductVo(productTypeVo);
    }

    @RequestMapping(value = "/deleteProductTypeById")
    @ResponseBody
    public void deleteProductTypeById(int id) {
        productService.deleteProductTypeById(id);
    }

    @RequestMapping(value = "/addProduct")
    @ResponseBody
    public void addProduct(Product product) {
        product.setCreateTime(new Date());
        product.setSellNum(0L);
        product.setAuditStatus(0);
        productService.addProduct(product);
    }

    @RequestMapping(value = "/auditProduct")
    @ResponseBody
    public void auditProduct(int id, int auditStatus) {
        productService.auditProduct(id, auditStatus);
    }

    @RequestMapping(value = "/getProductById")
    @ResponseBody
    public Product getProductById(int id) {
        return productService.getProductById(id);
    }

    @RequestMapping(value = "/updateProduct")
    @ResponseBody
    public void updateProduct(Product product) {
        productService.updateProduct(product);
    }

    @RequestMapping(value = "/deleteProductById")
    @ResponseBody
    public void deleteProductById(int id) {
        productService.deleteProductById(id);
    }

    @RequestMapping(value = "/queryProductByVo")
    @ResponseBody
    public List<Product> queryProductByVo(ProductVo productVo) {
        return productService.queryProductByVo(productVo);
    }

    @RequestMapping(value = "/updateProductByStatus")
    @ResponseBody
    public void updateProductByStatus(int id, int auditStatus) {
        productService.updateProductByStatus(id, auditStatus);
    }

    @RequestMapping(value = "/queryProductByIds")
    @ResponseBody
    public List<Product> queryProductByIds(String keyWord) {
        return productService.queryProductByIds(keyWord);
    }
}
