package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyArraysUtil;
import cn.zkj.algorithm.utils.MyPrinter;

public class SelectOrder {

    public static void main(String[] args) {
        SelectOrder s= new SelectOrder();
        int[]arr = new int[20];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*20);
        }
        MyPrinter.printArrays(s::selectOrder,arr);
    }

    public void order(int[]arr){



        for (int x=0;x<arr.length;x++){
            int minIndex=x;
            int min=arr[x];
            for (int y=x;y<arr.length;y++){
                if(min>arr[y]){
                    min=arr[y];
                    minIndex=y;
                }

            }
            int temp=arr[x];
            arr[x]=min;
            arr[minIndex]=temp;
        }

    }


    public void selectOrder(int[]arr){
        for (int x=0;x<arr.length-1;x++){
            int min = arr[x];
            int minIndex = x;
            for (int y=x+1;y<arr.length;y++){
                if (arr[y]<min){
                    min = arr[y];
                    minIndex = y;
                }
            }
            MyArraysUtil.swapVal(arr,x,minIndex);
        }
    }
}
