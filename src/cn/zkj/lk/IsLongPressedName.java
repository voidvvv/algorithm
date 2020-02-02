package cn.zkj.lk;

import java.util.Stack;
import java.util.stream.IntStream;

public class IsLongPressedName {
    public static void main(String[] args) {
        Stack<Integer> sd =new Stack();


        sd.add(2);
        sd.add(3);
        int size = sd.size();
//        System.out.println(add);
        System.out.println(sd.isEmpty());
        System.out.println(size);
    }
    public boolean isLongPressedName(String name, String typed) {
        int a=0;
        int b=0;

        while (a<name.length()){
            if (b<typed.length()){
                if (name.charAt(a)==typed.charAt(b)){
                    b++;
                    a++;
                }else if (a>0&&name.charAt(a-1)==typed.charAt(b)){
                    b++;
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        while (b<typed.length()){
            if (name.charAt(a-1)!=typed.charAt(b)){
                return false;
            }
            b++;
        }

        return true;

    }
}
