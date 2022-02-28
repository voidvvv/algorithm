package cn.zkj.proxy;

import cn.zkj.proxy.dto.MyOnlyInterFace;
import cn.zkj.proxy.dto.MyTest;
import cn.zkj.proxy.dto.MyTestInterFace;
import cn.zkj.proxy.handler.InvocationHandlerImpl;
import cn.zkj.proxy.handler.NoObjInvocationHandler;

import java.lang.reflect.Proxy;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:16
 */
public class ProxyTest {
    public static void main(String[] args) {
        MyOnlyInterFace o =(MyOnlyInterFace) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{MyOnlyInterFace.class}, new NoObjInvocationHandler());
        o.only();
    }

    public static void test01(){
        MyTest myTest = new MyTest();

        InvocationHandlerImpl handler = new InvocationHandlerImpl(myTest);

        MyTestInterFace o =(MyTestInterFace) Proxy.newProxyInstance(myTest.getClass().getClassLoader(), myTest.getClass().getInterfaces(), handler);

        System.out.println(o.say());
    }
}
