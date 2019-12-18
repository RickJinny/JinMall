package com.rick.jinmall.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserInfo {
    // id
    private Integer id;
    // 姓名
    private String name;
    // 性别: 1是男; 2是女
    private Integer sex;
    // 年龄
    private Integer age;
    // 生日
    private String birthday;
    // 用户名
    private String account;
    // 密码
    private String password;
    // 用户手机号
    private String userPhone;
    // 地址
    private String address;
    // 用户微信
    private String userWeChat;
    // 用户qq
    private String userQQ;
    // 用户邮箱
    private String userEmail;
}
