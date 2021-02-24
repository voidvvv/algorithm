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
        b.bubleTest02(arr);
        System.out.println(Arrays.toString(arr));
    }

    //冒泡排序方法，以升序排序为例子：
    public void bubbleSort(int[] arr){
        //获取数组的长度
        int len=arr.length;

        //从1开始，双重遍历数组
        for (int x=1;x<len;x++){
            //将第二重循环，将每一项与之后的比较，将较大的放在后面，达成升序
            for (int y=0;y<len-x;y++){
                if (arr[y]>arr[y+1]){
                    int temp=arr[y];
                    arr[y]=arr[y+1];
                    arr[y+1]=temp;
                }
            }
            //依次循环，达成冒泡排序
        }
    }

    //冒泡排序方法，以升序排序为例子：
    public void bubbleSort2(int[] arr){
        if(arr==null||arr.length==0){
            return;
        }

        for (int x=1;x<arr.length;x++){
            for (int y=0;y<arr.length-x;y++){
                if (arr[y]>arr[y+1]){
                    swap(arr,y,y+1);
                }
            }
        }
    }

    private void swap(int[] arr, int y, int i) {
        int i1 = arr[y];
        arr[y] = arr[i];
        arr[i] = i1;

    }

    public void bubleTest02(int[]arr){
        for (int x=1;x<arr.length;x++){
            for (int y =0;y<arr.length-x;y++){
                if (arr[y]>arr[y+1]){
                    swap(arr,y,y+1);
                }

            }

        }
    }

}
