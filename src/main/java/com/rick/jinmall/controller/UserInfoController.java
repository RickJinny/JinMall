package com.rick.jinmall.controller;

import com.rick.jinmall.bean.UserInfo;
import com.rick.jinmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
