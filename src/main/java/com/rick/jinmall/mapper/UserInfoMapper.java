package com.rick.jinmall.mapper;

import com.rick.jinmall.bean.UserInfo;

public interface UserInfoMapper {

    /**
     * 获取用户信息
     */
    UserInfo getUserInfo();

    /**
     * 增加用户信息
     */
    void insertUserInfo(UserInfo userInfo);

}
