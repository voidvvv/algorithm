package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

public class InsertSort {

    public static void main(String[] args) {
        InsertSort i = new InsertSort();
        MyPrinter.printDefaultArrays(i::insertSort04);

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

    public void insertSort02(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int curVal = arr[x];
            while (y>=0&&arr[y]>curVal){
                arr[y+1]= arr[y];
                y--;
            }
            arr[y+1] = curVal;
        }
    }

    public void insertSort03(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int curVal = arr[x];
            while (y>=0&&arr[y]>=curVal){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = curVal;
        }
    }

    public void insertSort04(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y =x-1;
            int cur = arr[x];
            while (y>=0&&arr[y]>cur){
                arr[y+1]=arr[y];
                y--;
            }
            arr[y+1] = cur;
        }
    }

    public void insertSort05(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int curVal = arr[x];
            while (y>=0&&arr[y]>curVal){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = curVal;
        }
    }
}
