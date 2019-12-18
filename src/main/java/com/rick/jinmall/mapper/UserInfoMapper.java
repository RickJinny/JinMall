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

    /**
     * 更新用户信息
     */
    void updateUserInfo(UserInfo userInfo);

    /**
     * 根据用户id，查找用户信息
     */
    UserInfo getUserInfoById(int id);
}
