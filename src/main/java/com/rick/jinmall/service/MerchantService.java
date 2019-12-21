package com.rick.jinmall.service;

import com.rick.jinmall.bean.merchant.Merchant;

public interface MerchantService {

    void addMerchant(Merchant merchant);

    void updateMerchant(Merchant merchant);

    Merchant getMerchantById(int id);

    void updateMerchantAuditStatus(int id, int auditStatus);

    void updateMerchantSoldOut(int id, int soldOut);
}
