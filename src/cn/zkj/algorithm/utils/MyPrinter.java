package cn.zkj.algorithm.utils;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/24
 * @version: 01
 */
public class MyPrinter {
    public static void printDefaultArrays(MySortArrayInterFace sort){
        int[] ints = MyArraysUtil.newArray(20, 90);
        printArrays(sort,ints);
    }

    public static void printArrays(MySortArrayInterFace sort,int[] arr){
        if (arr==null||arr.length==0||arr.length>1000){
            throw new RuntimeException("!!!");
        }
        System.out.println("排序前："+Arrays.toString(arr));
        sort.sort(arr);
        checkSotStatus(arr);
        System.out.println("排序后："+Arrays.toString(arr));
    }

    private static void checkSotStatus(int[] arr) {
        for (int x=1;x<arr.length;x++){
            if (arr[x]<arr[x-1]){
                System.out.println("排序失败！");
                return;
            }
        }
        System.out.println("排序成功");
    }

    public static void printTimeConsuming(MySortArrayInterFace sort,int[] arr){
        SimpleDateFormat sim=new SimpleDateFormat("hh:mm:ss");
        System.out.println(sim.format(new Date()));

        sort.sort(arr);
        System.out.println(sim.format(new Date()));
    }

    public static void swap(int[]arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
