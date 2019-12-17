package com.rick.jinmall.service;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserInfoDao userInfoDao;

    public UserInfo getUserInfo() {
        return userInfoDao.getUserInfo();
    }
}
