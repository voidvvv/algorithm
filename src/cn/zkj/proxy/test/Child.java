package cn.zkj.proxy.test;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:56
 */
public class Child extends MyFather{
    public String name;
    public Child() {

    }

    public void test(){
        super.test();
    }

    public void test2(String name) {
        System.out.println("child test 2 "+name);
    }

    public static void main(String[] args) {
        Child c= new Child();
        c.test();
    }
}
