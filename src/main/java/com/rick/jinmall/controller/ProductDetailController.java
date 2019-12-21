package com.rick.jinmall.controller;

import com.rick.jinmall.bean.product.ProductDetail;
import com.rick.jinmall.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/productDetail")
public class ProductDetailController {

    @Autowired
    private ProductDetailService productDetailService;

    @RequestMapping(value = "/addProductDetail")
    @ResponseBody
    public void addProductDetail(ProductDetail productDetail) {
        productDetailService.addProductDetail(productDetail);
    }

    @RequestMapping(value = "/addProductDetail")
    @ResponseBody
    public ProductDetail getProductDetailById(int productId) {
        return productDetailService.getProductDetailById(productId);
    }
}
