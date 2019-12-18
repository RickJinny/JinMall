package com.rick.jinmall.service;

import com.rick.jinmall.bean.UserInfo;


public interface UserService {

    UserInfo getUserInfo();

    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    UserInfo getUserInfoById(int id);
}
