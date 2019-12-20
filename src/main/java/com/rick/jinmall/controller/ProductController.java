package com.rick.jinmall.controller;

import com.rick.jinmall.bean.product.ProductCategory;
import com.rick.jinmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/addProductType")
    @ResponseBody
    public void addProductType(ProductCategory productCategory) {
        productService.addProductType(productCategory);
    }

    @RequestMapping(value = "/getProductTypeById")
    @ResponseBody
    public ProductCategory getProductTypeById(int id){
        return productService.getProductTypeById(id);
    }

    @RequestMapping(value = "/getProductType")
    @ResponseBody
    public List<ProductCategory> getProductType(){
        return productService.getProductType();
    }

    @RequestMapping(value = "/updateProductTypeById")
    @ResponseBody
    public void updateProductTypeById(ProductCategory productCategory){
        productService.updateProductTypeById(productCategory);
    }
}
