package com.rick.jinmall.dao;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserInfoDao {

    @Autowired
    UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo() {
        return userInfoMapper.getUserInfo();
    }
}
