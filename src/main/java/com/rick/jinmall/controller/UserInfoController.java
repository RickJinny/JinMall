package com.rick.jinmall.controller;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.bean.UserInfoVo;
import com.rick.jinmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/getUserInfo")
    @ResponseBody
    public UserInfo getUserInfo() {
        UserInfo userInfo = userService.getUserInfo();
        if (userInfo != null) {
            System.out.println("name: " + userInfo.getName());
        }
        return userInfo;
    }

    @RequestMapping(value = "/registerUser")
    @ResponseBody
    public void registerUser(UserInfo userInfo) {
        userService.addUserInfo(userInfo);
    }

    @RequestMapping(value = "/updateUserInfo")
    @ResponseBody
    public String updateUserInfo(UserInfo userInfo, Model model) {
        userService.updateUserInfo(userInfo);
        return "success";
    }

    @RequestMapping(value = "/getUserInfoById")
    @ResponseBody
    public UserInfo getUserInfoById(int id, Model model) {
        UserInfo userInfo = userService.getUserInfoById(id);
        return userInfo;
    }

    @RequestMapping(value = "/queryUserInfo")
    @ResponseBody
    public List<UserInfo> queryUserInfo(UserInfoVo userInfoVo) {
        return userService.queryUserInfo(userInfoVo);
    }

    @RequestMapping(value = "/deleteUserInfoById")
    @ResponseBody
    public void deleteUserInfoById(int id) {
        userService.deleteUserInfoById(id);
    }
}
