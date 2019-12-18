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
}
