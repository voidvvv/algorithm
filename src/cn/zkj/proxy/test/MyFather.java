package cn.zkj.proxy.test;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/28 14:55
 */
public class MyFather {
    public String name;
    protected MyFather(){

    }

    private MyFather(String name){

    }


    public void test(){
        test2("name");
    }

    public void test2(String name) {
        System.out.println("father test 2 "+name);
    }


}
