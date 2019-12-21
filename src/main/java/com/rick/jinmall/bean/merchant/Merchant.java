package com.rick.jinmall.bean.merchant;

import lombok.Data;

@Data
public class Merchant {
    // id
    private Integer id;

    // 商家名称
    private String merchantName;

    // 店铺名称
    private String merchantShopName;

    // 商家账号
    private String merchantAccount;

    // 商家密码
    private String merchantPassword;

    // 经营范围
    private String merchantScope;

    // 审核状态：1是提交成功; 2是审核通过; 3是审核不通过
    private Integer auditStatus;

    // 1是正常; 2是下架
    private Integer soldOut;

}
