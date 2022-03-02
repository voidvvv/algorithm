package cn.zkj.lk;


import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        DelayQueue<MyDelayed> d = new DelayQueue<MyDelayed>();

        d.add(new MyDelayed());

        MyDelayed poll = d.poll();
    }

    static class MyDelayed implements Delayed{

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.toSeconds(500000000);
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
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
