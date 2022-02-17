package cn.zkj.algorithm.queue;

import cn.zkj.algorithm.utils.MyArraysUtil;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/2/17
 * @version: 01
 */
public class Queue8_01 {
    private int max;
    private int arr[];
    private int count;

    public Queue8_01(int max) {
        this.max = max;
        this.arr = new int[max];
        this.count = 0;
    }

    public static void main(String[] args) {
        Queue8_01 q = new Queue8_01(8);
        q.check(0);
        System.out.println(q.count);
    }

    private void check(int x){
        if (x==max){
            print();
            return;
        }
        for (int i=0;i<max;i++){
            arr[x] = i;
            if (judge(x)){
                check(x+1);
            }
        }
    }

    private void print() {
        MyArraysUtil.printArr(this.arr);
        this.count++;
    }

    private boolean judge(int n){
        for (int x=0;x<n;x++){
            if (arr[x]==arr[n] || (Math.abs(arr[x]-arr[n]) == Math.abs(x-n))){
                return false;
            }
        }
        return true;
    }
}
