package com.rick.jinmall.dao;

import com.rick.jinmall.bean.merchant.Merchant;
import com.rick.jinmall.mapper.MerchantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MerchantDao {

    @Autowired
    private MerchantMapper merchantMapper;

    public void addMerchant(Merchant merchant) {
        merchantMapper.addMerchant(merchant);
    }

    public void updateMerchant(Merchant merchant) {
        merchantMapper.updateMerchant(merchant);
    }

    public Merchant getMerchantById(int id) {
        return merchantMapper.getMerchantById(id);
    }

    public void updateMerchantAuditStatus(Merchant merchant) {
        merchantMapper.updateMerchantAuditStatus(merchant);
    }

    public void updateMerchantSoldOut(Merchant merchant) {
        merchantMapper.updateMerchantSoldOut(merchant);
    }
}
