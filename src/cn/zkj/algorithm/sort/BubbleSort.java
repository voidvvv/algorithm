package cn.zkj.algorithm.sort;

import java.util.Arrays;

public class BubbleSort   {
    public static void main(String[] args) {
        int[]arr=new int[15];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*20);
        }
        BubbleSort b = new BubbleSort();
        System.out.println(Arrays.toString(arr));
        b.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr){
        int len=arr.length;
        for (int x=1;x<len;x++){
            for (int y=0;y<len-x;y++){
                if (arr[y]>arr[y+1]){
                    int temp=arr[y];
                    arr[y]=arr[y+1];
                    arr[y+1]=temp;
                }
            }
        }
    }
}
