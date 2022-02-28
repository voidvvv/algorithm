package cn.zkj.proxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:18
 */
public class InvocationHandlerImpl implements InvocationHandler {
    private Object origin;

    public InvocationHandlerImpl(Object origin) {
        this.origin = origin;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("handler before!");
//        System.out.println(proxy);
        Object ans = method.invoke(origin, args);
        System.out.println("handler after!");
        return ans;
    }
}
