package cn.zkj.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:25
 */
public class NoObjInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("NoObjInvocationHandler");
        return "s";
    }
}
