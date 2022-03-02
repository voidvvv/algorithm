package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

public class InsertSort {


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

    public void insertSort06(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y =x-1;
            int curVal = arr[x];
            while (y>=0&& arr[y]>curVal){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = curVal;

        }
    }

    public void insertSort07(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int minVal = arr[x];

            while (y>=0 && arr[y]>minVal){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = minVal;

        }
    }

    public void insertSort08(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int minVal = arr[x];

            while (y>=0 && arr[y]>minVal){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = minVal;
        }
    }

    public void insertSort09(int[] arr){
        for (int x=1;x<arr.length;x++){
            int i = x-1;
            int minVal =arr[x];

            while (i>=0 && arr[i]>=minVal){
                arr[i+1] = arr[i];
                i--;
            }
            arr[i+1] = minVal;

        }
    }

    public void insertSort10(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int c = arr[x];

            while (y>=0 && arr[y]>c){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = c;
        }
    }

    public void insertSort11(int[] arr){
        for (int x=1;x<arr.length;x++){
            int y = x-1;
            int v = arr[x];
            while (y>=0 && arr[y]>v){
                arr[y+1] = arr[y];
                y--;
            }
            arr[y+1] = v;
        }
    }

    public static void main(String[] args) {
        InsertSort i = new InsertSort();
        MyPrinter.printDefaultArrays(i::insertSort11);

    }
}
