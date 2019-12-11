package cn.zkj.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSort {

    public static void main(String[] args) {
        InsertSort i = new InsertSort();
        int[]arr = new int[80000];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*100000);
        }
        SimpleDateFormat sim=new SimpleDateFormat("hh:mm:ss");
        System.out.println(sim.format(new Date()));

        i.insertSort(arr);
        System.out.println(sim.format(new Date()));

    }

    //插入排序
    //101,39,119,7
    public void insertSort(int[] arr){
        int index1=1;
        while (index1<arr.length){
            int insertIndex=index1-1;
            int insertVal=arr[index1];
            while (insertIndex>=0&&insertVal<arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertVal;
            index1++;
        }
    }


}
