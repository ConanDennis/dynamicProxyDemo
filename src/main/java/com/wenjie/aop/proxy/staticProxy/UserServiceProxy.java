package com.wenjie.aop.proxy.staticProxy;

import com.wenjie.aop.service.IUserService;
import com.wenjie.aop.service.impl.UserService;

/**
 * Created by wenjie.zhou on 2018/4/4.
 */
public class UserServiceProxy implements IUserService {

    private UserService userService;

    public UserServiceProxy(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("代理类方法，进行了增强。。。");
        System.out.println("事务开始。。。");
        // 调用委托类的方法;
        userService.addUser();
        System.out.println("处理结束。。。");
    }

    public void editUser() {
        System.out.println("代理类方法，进行了增强。。。");
        System.out.println("事务开始。。。");
        // 调用委托类的方法;
        userService.editUser();
        System.out.println("事务结束。。。");
    }

}
