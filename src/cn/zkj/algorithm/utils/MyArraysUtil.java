package cn.zkj.algorithm.utils;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Author: zhaoKaiJie
 * @Description: 数组工具类
 * @Date: 2021/2/24
 * @version: 01
 */
public class MyArraysUtil {
    public static int[] newArray(int length,int range){
        Random r = new SecureRandom();

        int[] arr = new int[length];

        for (int x=0;x<length;x++){
            arr[x] = r.nextInt(range);
        }
        return arr;
    }

    public static void swapVal(int[] arr,int a,int b){
        int temp= arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
