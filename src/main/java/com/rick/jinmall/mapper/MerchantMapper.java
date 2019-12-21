package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.merchant.Merchant;

public interface MerchantMapper {

    void addMerchant(Merchant merchant);

    void updateMerchant(Merchant merchant);

    Merchant getMerchantById(int id);

    void updateMerchantAuditStatus(Merchant merchant);

    void updateMerchantSoldOut(Merchant merchant);

}
