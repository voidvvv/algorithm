package cn.zkj.proxy;

import cn.zkj.proxy.dto.MyTest;
import cn.zkj.proxy.dto.MyTestInterFace;
import cn.zkj.proxy.handler.InvocationHandlerImpl;
import cn.zkj.proxy.test.Child;
import cn.zkj.proxy.test.MyFather;

import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:16
 */
public class ProxyTest {
    public static void main(String[] args) throws IOException {
        Child c = new Child();
        c.name = "aaa";
        MyFather mf = c;
        System.out.println(mf.name);
        System.out.println(c.name);
    }
    public static void test02() throws IOException {
//        MyOnlyInterFace o =(MyOnlyInterFace) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{MyOnlyInterFace.class}, new NoObjInvocationHandler());
//        o.only();
//        InvocationHandler invocationHandler = Proxy.getInvocationHandler(o);
//        System.out.println(invocationHandler);
//
//        byte[] myvoids = ProxyGenerator.generateProxyClass("myvoid", new Class[]{MyTestInterFace.class});
//
//        FileOutputStream fos = new FileOutputStream("myvoids");
//        fos.write(myvoids);
//        System.out.println(Arrays.toString(myvoids));
    }
    public static void test01(){
        MyTest myTest = new MyTest();

        InvocationHandlerImpl handler = new InvocationHandlerImpl(myTest);

        MyTestInterFace o =(MyTestInterFace) Proxy.newProxyInstance(myTest.getClass().getClassLoader(), myTest.getClass().getInterfaces(), handler);


        System.out.println(o.say());


    }
}