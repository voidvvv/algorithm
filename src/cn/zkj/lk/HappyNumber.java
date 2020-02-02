package cn.zkj.lk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        HappyNumber h =new HappyNumber();
        boolean happy = h.isHappy(2);
        System.out.println(happy);
    }
    public boolean isHappy(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(n);
        int sum=0;
        while (n!=1){
            while (n>0){
                int re=n%10;
                int res=re*re;
                sum+=res;
                n/=10;
            }

            n=sum;
            sum=0;

            if (list.contains(n)){
                return false;
            }
            list.add(n);

        }
        return true;
    }
}
