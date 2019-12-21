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
        merchant.setAuditStatus(1);
        merchant.setSoldOut(1);
        merchantDao.addMerchant(merchant);
    }

    @Override
    public void updateMerchant(Merchant merchant) {
        merchant.setSoldOut(1);
        merchantDao.updateMerchant(merchant);
    }

    @Override
    public Merchant getMerchantById(int id) {
        return merchantDao.getMerchantById(id);
    }

    @Override
    public void updateMerchantAuditStatus(int id, int auditStatus) {
        Merchant merchant = new Merchant();
        merchant.setId(id);
        merchant.setAuditStatus(auditStatus);
        merchantDao.updateMerchantAuditStatus(merchant);
    }

    @Override
    public void updateMerchantSoldOut(int id, int soldOut) {
        Merchant merchant = new Merchant();
        merchant.setId(id);
        merchant.setSoldOut(soldOut);
        merchantDao.updateMerchantSoldOut(merchant);
    }
}
