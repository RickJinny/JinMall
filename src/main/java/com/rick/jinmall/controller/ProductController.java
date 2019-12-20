package com.rick.jinmall.controller;

import com.rick.jinmall.bean.product.ProductType;
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
}
