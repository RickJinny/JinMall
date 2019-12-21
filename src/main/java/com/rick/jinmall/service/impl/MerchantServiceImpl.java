package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.merchant.Merchant;
import com.rick.jinmall.dao.MerchantDao;
import com.rick.jinmall.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantDao merchantDao;

    @Override
    public void addMerchant(Merchant merchant) {
        merchantDao.addMerchant(merchant);
    }

    @Override
    public void updateMerchant(Merchant merchant) {
        merchantDao.updateMerchant(merchant);
    }

    @Override
    public Merchant getMerchantById(int id) {
        return merchantDao.getMerchantById(id);
    }

    @Override
    public void updateMerchantAuditStatus(Merchant merchant) {
        merchantDao.updateMerchantAuditStatus(merchant);
    }

    @Override
    public void updateMerchantSoldOut(Merchant merchant) {
        merchantDao.updateMerchantSoldOut(merchant);
    }
}
