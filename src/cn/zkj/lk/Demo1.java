package cn.zkj.lk;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Demo1 {
    public static void main(String[] args) {
        //map entryset 何时初始化
        HashMap<String,String> map = new HashMap<>();
        String key01 = "key";

        map.put(key01,"key01");

        String v01 = map.get(key01);


        Set<Map.Entry<String, String>> entries = map.entrySet();
        map.toString();
        map.toString();
        System.out.println(v01);
    }

    public static void printOut(int i ){
        if(i>=10)
            printOut(i/10);
        printDigit(i%10);
    }

    private static void printDigit(int i){
        System.out.println(i);
    }
}
