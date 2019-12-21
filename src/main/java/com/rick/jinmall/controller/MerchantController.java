package com.rick.jinmall.controller;

import com.rick.jinmall.bean.merchant.Merchant;
import com.rick.jinmall.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/merchant")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/addMerchant")
    @ResponseBody
    public void addMerchant(Merchant merchant) {
        merchantService.addMerchant(merchant);
    }

    @RequestMapping(value = "/updateMerchant")
    @ResponseBody
    public void updateMerchant(Merchant merchant) {
        merchantService.updateMerchant(merchant);
    }

    @RequestMapping(value = "/getMerchantById")
    @ResponseBody
    public Merchant getMerchantById(int id) {
        return merchantService.getMerchantById(id);
    }

    @RequestMapping(value = "/updateMerchantAuditStatus")
    @ResponseBody
    public void updateMerchantAuditStatus(int id, int auditStatus) {
        merchantService.updateMerchantAuditStatus(id, auditStatus);
    }

    @RequestMapping(value = "/updateMerchantSoldOut")
    @ResponseBody
    public void updateMerchantSoldOut(int id, int soldOut) {
        merchantService.updateMerchantSoldOut(id, soldOut);
    }
}
