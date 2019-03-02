package com.atguigu.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.atguigu.gmall.bean.UserAddress;
import com.atguigu.gmall.bean.UserInfo;
import com.atguigu.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    //此时使用远程注入,注入的不是ioc的bean实例,实际是dubbo的协议地址
    @Reference
    UserService userService;

    @RequestMapping("users")
    @ResponseBody
    public List<UserInfo> getAllUser(){

        List<UserInfo> userInfos = userService.getAllUser();

        return userInfos;
    }

    @RequestMapping("addresses")
    @ResponseBody
    public List<UserAddress> getAllAddress(){
        List<UserAddress> userAddresses = userService.getAllAddress();
        return userAddresses;
    }
}
