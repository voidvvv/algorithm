package cn.zkj.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int [] arr =new int[80000];
        int[] temp =new int[80000];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*100000);
        }
        MergeSort m = new MergeSort();
        SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss");

        System.out.println(new Date().getTime());
        m.divide(arr,0,arr.length-1,temp);
        System.out.println(new Date().getTime());
    }

    public void divide(int[]arr,int left,int right,int[] temp){

        if (left<right){
            int mid=(left+right)/2;
            divide(arr,left,mid,temp);
            divide(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);

        }
    }

    public void merge(int[]arr,int left,int mid,int right,int[]temp){
        int i=left;
        int j = mid+1;
        int t =0;

        //1，先吧左右两边的数组按照顺序放入临时数组中，直到两边的有序数组，有一组放入完毕
        while (i<=mid&&j<=right){
            if (arr[i]>=arr[j]){
                temp[t]=arr[j];
                t++;
                j++;
            }else {
                temp[t]=arr[i];
                t++;
                i++;
            }
        }

        //2.将剩余数组的剩下部分全部放入temp中
        while (i<=mid){
            temp[t]=arr[i];
            t++;
            i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;
            j++;
        }

        //3.将temp数组元素拷贝到arr中
        //不是每次都拷贝
        t=0;
        int tempLeft=left;
        while (tempLeft<=right){
            arr[tempLeft]=temp[t];

            t++;
            tempLeft++;



        }


    }

}
