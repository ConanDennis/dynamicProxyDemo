package com.wenjie.aop.service.impl;

import com.wenjie.aop.service.IUserService;

/**
 * Created by wenjie.zhou on 2018/4/4.
 */
public class UserService implements IUserService{
    public void addUser() {
        System.out.println("增加一个用户。。。");
    }

    public void editUser() {
        System.out.println("编辑一个用户。。。");
    }
}
