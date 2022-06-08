package cn.zkj.util.comp;

import java.lang.reflect.Field;

/**
 * @Classname Test02
 * @Description
 * @Date 2022/4/6 14:20
 * @Created by zkj
 */

public class Test02 <T>{
    T name;



    public static void main(String[] args) throws NoSuchFieldException {
        Class<Test02> test02Class = Test02.class;

        Field fi = test02Class.getDeclaredField("name");

        System.out.println(fi.getType());

        Test02<String> t2 = new Test02<>();

        Class<? extends Test02> aClass = t2.getClass();

        System.out.println(aClass.getDeclaredField("name"));

        tl(1);
    }


    public static int tl(long l){
        return 1;
    }
}
