package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyArraysUtil;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int []arr={5,4,3,1,-33,99,44,999,9,10,55,9,0,-1,86};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[]arr){
        System.out.println("开始堆排序啦！！");

        int temp;
        //这里，因为是完全二叉树，所以arr.length/2-1其实就是所有的非叶子结点！！！！这里一定要记住
        for (int x=arr.length/2-1;x>=0;x--){
            adjust(arr,arr.length,x);
        }

        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjust(arr,j,0);
        }
    }

    /**
     *
     * @param arr 要排序的数组
     * @param length 要对多少个元素进行调整，length在逐渐减少
     * @param i 非叶子节点的位置
     */
    public static void adjust(int[]arr,int length,int i){
        //先将当前节点的值保存下来,保存为一个临时变量
        int temp=arr[i];
        //开始调整
        //找i的左子节点（2*i+1），与右子节点（2*i+2）


        for (int k=2*i+1;k<length;k=k*2+1){
            if (k+1<length&&arr[k]<arr[k+1]){
                k++;
            }
            if (temp<arr[k]){
                arr[i]=arr[k];
                i=k;
            }else {
                break;
            }
        }
        arr[i]=temp;
    }


    public static void myHeapSort02(int[]arr){
        for (int x= (arr.length/2)-1;x>=0;x--){
            heapFy02(arr,x,arr.length);
        }

        for (int x=0;x<arr.length;x++){
            MyArraysUtil.swapVal(arr,0,arr.length-x-1);
            heapFy02(arr,0,arr.length-x-1);
        }
    }

    private static void heapFy02(int[] arr, int start, int length) {
        for (int target = start*2+1;target<length;target = target*2+1){
            if (arr[target]<arr[target+1]){
                target++;
            }

            if (arr[start]<arr[target]){
                MyArraysUtil.swapVal(arr,start,target);
            }
            start = target;
        }
    }
}
