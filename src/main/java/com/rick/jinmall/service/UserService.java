package com.rick.jinmall.service;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.bean.UserInfoVo;

import java.util.List;


public interface UserService {

    UserInfo getUserInfo();

    void addUserInfo(UserInfo userInfo);

    void updateUserInfo(UserInfo userInfo);

    UserInfo getUserInfoById(int id);

    List<UserInfo> queryUserInfo(UserInfoVo userInfoVo);

    void deleteUserInfoById(int id);
}
