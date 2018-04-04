package com.wenjie.aop.proxy.cglibDynamicProxy;

import com.wenjie.aop.service.IUserService;
import com.wenjie.aop.service.impl.UserService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by wenjie.zhou on 2018/4/4.
 */
public class CglibDynamicProxy {

    //创建代理对象   需要传入真实对象和事务对象
    public static Object getAgencyObj(final IUserService target){

        //1.创建增强器    底层实现是通过二进制码的方式
        Enhancer enhancer = new Enhancer();

        //2.设置接口
        enhancer.setInterfaces(target.getClass().getInterfaces());

        //3.设置父类  cgLib创建的代理对象都是目标对象的子类
        enhancer.setSuperclass(target.getClass());

        //4.设置回调
        enhancer.setCallback(new MethodInterceptor() {

            @Override
            public Object intercept(Object proxy, Method method, Object[] args,
                    MethodProxy methodProxy) throws Throwable {

                System.out.println("代理类方法，进行了增强。。。");
                System.out.println("事务开始。。。");

                Object result = method.invoke(target, args);
                System.out.println("处理结束。。。");

                return result;
            }
        });

        //获取代理对象
        return enhancer.create();
    }
}
