package com.rick.jinmall.service.impl;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.dao.UserInfoDao;
import com.rick.jinmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserInfoDao userInfoDao;

    @Override
    public UserInfo getUserInfo() {
        return userInfoDao.getUserInfo();
    }

    @Override
    public void addUserInfo(UserInfo userInfo) {
        userInfoDao.addUserInfo(userInfo);
    }

    @Override
    public void updateUserInfo(UserInfo userInfo) {
        userInfoDao.updateUserInfo(userInfo);
    }

    @Override
    public UserInfo getUserInfoById(int id) {
        return userInfoDao.getUserInfoById(id);
    }
}
