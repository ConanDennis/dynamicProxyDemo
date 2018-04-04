package com.wenjie.aop;

import com.wenjie.aop.proxy.cglibDynamicProxy.CglibDynamicProxy;
import com.wenjie.aop.proxy.jdkDynamicProxy.JdkDynamicProxy;
import com.wenjie.aop.proxy.staticProxy.UserServiceProxy;
import com.wenjie.aop.service.IUserService;
import com.wenjie.aop.service.impl.UserService;
import org.junit.Test;

/**
 * Created by wenjie.zhou on 2018/4/4.
 */


public class ProxyTest {

    @Test
    public void static_test1() {
        UserService userService = new UserService();
        UserServiceProxy proxy = new UserServiceProxy(userService);
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
    }

    @Test
    public void jdk_test2() {
        //只能用接口，将得到代理对象的类型强制转化为UserService时会报错
        IUserService userService = new UserService();
        IUserService proxy = (IUserService) JdkDynamicProxy.getAgencyObj(userService);
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
    }

    @Test
    public void cglib_test3() {
        //只能用实现类，强不强转对象都可以运行
        IUserService userService = new UserService();
        IUserService proxy = (UserService) CglibDynamicProxy.getAgencyObj(userService);
        proxy.addUser();
        System.out.println("----------分割线----------");
        proxy.editUser();
    }
}
