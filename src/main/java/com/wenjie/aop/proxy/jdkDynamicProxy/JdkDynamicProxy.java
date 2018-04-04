package com.wenjie.aop.proxy.jdkDynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wenjie.zhou on 2018/4/4.
 */
public class JdkDynamicProxy {

    public static Object getAgencyObj(final Object target){

        Object agencyObj = Proxy.newProxyInstance(
                //获取目标对象类的加载器
                target.getClass().getClassLoader(),
                //获取对象接口的Class对象数组
                target.getClass().getInterfaces(),
                //一个内部类，用于创建监听对象
                new InvocationHandler() {
                    /**
                     * 通过反射机制获得实现类中方法的实例  method 及方法的参数 args 这取决于代理对象 agencyObj调用了那个方法。
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("代理类方法，进行了增强。。。");
                        System.out.println("事务开始。。。");

                        Object result = method.invoke(target, args);
                        System.out.println("处理结束。。。");

                        return result;
                    }
                });

        return agencyObj;

    }

}