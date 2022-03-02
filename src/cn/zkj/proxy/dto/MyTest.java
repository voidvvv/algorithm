package cn.zkj.proxy.dto;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:17
 */
public class MyTest implements MyTestInterFace{
    @Override
    public String say() {
        System.out.println("MyTest say method!");
        return "say!";
    }
}
