package com.rick.jinmall.seckill.controller;

import com.rick.jinmall.seckill.model.ItemKill;
import com.rick.jinmall.seckill.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProductController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    private static final String prefix = "item";

    @Autowired
    private ProductService productService;

    @RequestMapping(value = {"/", "/index", prefix + "/list", prefix + "/index.html"})
    public String list(ModelMap modelMap) {
        try {
            List<ItemKill> itemKills = productService.getKillProductList();
            modelMap.put("list", itemKills);
        } catch (Exception e) {
            logger.error("获取待秒杀商品列表，发生异常: ", e.fillInStackTrace());
            return "redict:/base/error";
        }
        return "list";
    }

    /**
     * 获取待秒杀商品的详情
     */
    @RequestMapping(value = prefix + "/getProductDetail/{id}", method = RequestMethod.GET)
    public String getProductDetail(@PathVariable Integer id, ModelMap modelMap) {
        if (id == null || id <= 0) {
            return "redirect:/base/error";
        }
        try {
            ItemKill detail = productService.getProductDetail(id);
            modelMap.put("detail", detail);
        } catch (Exception e) {
            logger.error("获取待秒杀商品的详情-发生异常：id={}", id, e.fillInStackTrace());
            return "redirect:/base/error";
        }
        return "info";
    }
}
