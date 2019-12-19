package com.rick.jinmall.dao;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.bean.UserInfoVo;
import com.rick.jinmall.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserInfoDao {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo getUserInfo() {
        return userInfoMapper.getUserInfo();
    }

    public void addUserInfo(UserInfo userInfo) {
        userInfoMapper.insertUserInfo(userInfo);
    }

    public void updateUserInfo(UserInfo userInfo) {
        userInfoMapper.updateUserInfo(userInfo);
    }

    public UserInfo getUserInfoById(int id) {
        return userInfoMapper.getUserInfoById(id);
    }

    public List<UserInfo> queryUserInfo(UserInfoVo userInfoVo) {
        return userInfoMapper.queryUserInfo(userInfoVo);
    }

    public void deleteUserInfoById(int id) {
        userInfoMapper.deleteUserInfoById(id);
    }
}
