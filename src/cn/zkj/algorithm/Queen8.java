package cn.zkj.algorithm;

import java.sql.Date;
import java.sql.Time;

public class Queen8 {
    int max ;
    int[] arr;
    int count;
    int count2;

    public Queen8(){
        max=8;
        arr=new int[max];
        count=0;
        count2=0;
    }
    public void checkt(){
        long l = System.currentTimeMillis();
        check(0);
        long l1 = System.currentTimeMillis();
        long re = l1-l;
        System.out.println("一共用时："+re+"毫秒");
        System.out.println(count2);
    }

    public void check(int n){
        if (n==max){
            print();
            return;
        }

        for (int x=0;x<max;x++){
            arr[n]=x;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    public boolean judge(int n){
        count2++;
        for (int i=0;i<n;i++){
            if (arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    public void print(){
        for (int x=0;x<arr.length;x++){
            System.out.print(arr[x]+" ");
        }
        count++;
        System.out.println("这是第"+count+"次");
    }

    public void test(int n){
        if(n==0){
            System.out.println("出口");
            return;
        }
        test(n-1);
    }
}
