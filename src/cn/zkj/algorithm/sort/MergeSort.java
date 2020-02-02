package cn.zkj.algorithm.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MergeSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int [] arr =new int[10];
        int[] temp =new int[10];
        for (int x=0;x<arr.length;x++){
            arr[x]=(int)(Math.random()*100);
        }
        MergeSort m = new MergeSort();
        /*SimpleDateFormat s= new SimpleDateFormat("hh:mm:ss");

        System.out.println(new Date().getTime());
        m.divide1(arr,0,arr.length-1,temp);
        System.out.println(new Date().getTime());*/
        System.out.println(Arrays.toString(arr));
        m.divide2(arr,0,arr.length-1,temp);
        System.out.println(Arrays.toString(arr));
    }
    //分+合
    public void divide(int[]arr,int left,int right,int[] temp){

        if (left<right){
            int mid=(left+right)/2;
            divide(arr,left,mid,temp);
            divide(arr,mid+1,right,temp);
            merge(arr,left,mid,right,temp);

        }
    }
    //合
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

    //归并排序 12.11
    //合
    public void merge1(int[]arr,int left,int mid,int right,int[]temp){
        int i=left;
        int j=mid+1;

        int t =0;
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t] = arr[i];
                i++;
                t++;
            }else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //将剩余数组中的部分全部放入temp中
        while (i<=mid){
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j<=right){
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将temp放入arr中
        t=0;
        int indexLeft=left;

        while (indexLeft<=right){
            arr[indexLeft] = temp[t];
            t++;
            indexLeft++;
        }

    }
    //分
    public void divide1(int[]arr,int left,int right,int[] temp){
        if (left<right){
            int mid = (left+right)/2;
            divide1(arr,left,mid,temp);
            divide1(arr,mid+1,right,temp);
            merge1(arr,left,mid,right,temp);
        }
    }

    //12.13
    //合
    public void merge2(int[]arr,int left,int mid,int right,int[]temp){
        int i=left;
        int j =mid+1;
        //1,不断从两边取值，找到较小的放入
        int t =0;
        while (i<=mid&j<=right){
            if (arr[i]<=arr[j]){
                temp[t]=arr[i];
                i++;
                t++;
            }else {
                temp[t]=arr[j];
                j++;
                t++;
            }

        }

        //2，将剩余的全部按顺序放入temp
        while (i<=mid){
            temp[t]=arr[i];
            t++;i++;
        }
        while (j<=right){
            temp[t]=arr[j];
            t++;j++;
        }

        //将temp放入原数组
        t=0;
        int leftIndex=left;
        while (leftIndex<=right){
            arr[leftIndex]=temp[t];
            t++;
            leftIndex++;
        }
    }

    //分
    public void divide2(int[]arr,int left,int right,int[] temp){
        if (left<right){
            int mid=(left+right)/2;
            divide2(arr,left,mid,temp);
            divide2(arr,mid+1,right,temp);

            merge2(arr,left,mid,right,temp);
        }
    }


}
