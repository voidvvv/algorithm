package cn.zkj.algorithm.queue;

import cn.zkj.algorithm.utils.MyArraysUtil;
import cn.zkj.algorithm.utils.MyPrinter;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/18 16:42
 */
public class Queue8_02 {
    private int max;
    private int[] arr;

    private int count;

    public Queue8_02(int max) {
        this.max = max;
        this.arr = new int[max];
        this.count = 0;
    }

    private void  check(int n){
        if (n==max){
//            print();
            this.count++;
            return;
        }

        for (int x=0;x<max;x++){
            arr[n] = x;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    private boolean judge(int n){
        for (int x=0;x<n;x++){
            if (arr[x]==arr[n] || Math.abs(arr[x]-arr[n]) == Math.abs(x-n)){
                return false;
            }

        }
        return true;
    }

    private void print(){
        MyArraysUtil.printArr(arr);
    }

    public static void main(String[] args) {
        for (int x=1;x<=15;x++){
            final int tx = x;
            ReentrantLock lock = new ReentrantLock();
            new  Thread(new Runnable() {
                @Override
                public void run() {
                    Queue8_02 q = new Queue8_02(tx);
                    q.check(0);
                    System.out.printf("queue: %d ,count %d",tx,q.count);
                    System.out.println();
                }
            }).start();
        }
    }
}
