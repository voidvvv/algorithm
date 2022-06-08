package cn.zkj.util.enums;

import java.util.Arrays;

/**
 * @Classname MyEnums
 * @Description
 * @Date 2022/4/27 16:52
 * @Created by zkj
 */
public enum MyEnums {
    Tom("tom01",11),
    Jerry("jerry01",22),
    Spike("spike01",33),
    No("no",-199),
    ;

    private final String name;
    private final int age;

    MyEnums(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static MyEnums tt(int age){
        return Arrays.stream(MyEnums.values()).filter(n -> n.age == age).findFirst().orElse(MyEnums.No);

    }

    public static void main(String[] args) {
        System.out.println(MyEnums.tt(1));
        System.out.println(MyEnums.tt(11));
        System.out.println(MyEnums.tt(12));
    }
}
