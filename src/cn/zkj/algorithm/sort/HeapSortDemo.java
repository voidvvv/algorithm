package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyArraysUtil;
import cn.zkj.algorithm.utils.MyPrinter;

public class HeapSortDemo {


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

    public void heapSort03(int[] arr){
        for (int x=arr.length/2-1;x>=0;x--){
            heapFy03(arr,x,arr.length);
        }
        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy03(arr,0,x);
        }
    }

    private void heapFy03(int[] arr, int cur, int length) {
        int curVal = arr[cur];
        for (int target = cur*2 +1;target<length;target = target*2+1){
            if (target+1<length&&arr[target]<arr[target+1]){
                target++;
            }
            if (arr[target]>curVal){
                arr[cur] = arr[target];
                cur = target;
            }else {
                break;
            }
        }
        arr[cur] = curVal;
    }

    /**
     * 在堆化的过程中，赋值cur下标的时候错用成了curVal
     * @param arr
     */
    public void heapSort04(int[] arr){
        for (int x=arr.length/2-1;x>=0;x--){
            heapFy04(arr,x,arr.length);
        }
        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy04(arr,0,x);
        }
    }

    private void heapFy04(int[] arr, int cur, int length) {
        int curVal = arr[cur];
        for (int t = 2*cur+1;t<length;t= t*2+1){
            if (t+1<length&&arr[t]<arr[t+1]){
                t++;
            }
            if (arr[t]>curVal){
                arr[cur] = arr[t];
                cur = t;
            }else {
                break;
            }
        }
        arr[cur] = curVal;
    }

    public void heapSort05(int[] arr){
        for (int x=arr.length/2-1;x>=0;x--){
            heapFy05(arr,x,arr.length);
        }
        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy05(arr,0,x);
        }
    }

    private void heapFy05(int[] arr, int cur, int length) {
        int curVal = arr[cur];
        for (int t=cur*2+1;t<length;t=t*2+1){
            if (t+1<length&&arr[t]<arr[t+1]){
                t++;
            }
            if (arr[t]>curVal){
                arr[cur] = arr[t];
                cur = t;
            }else {
                break;
            }
        }
        arr[cur] = curVal;
    }

    public void heapSort06(int[] arr){
        for (int x=arr.length/2-1;x>=0;x--){
            heapFy06(arr,x,arr.length);
        }
        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy06(arr,0,x);

        }
    }
//
    private void heapFy06(int[] arr, int cur, int length) {
        int curVal = arr[cur];
        for (int t =cur*2+1;t<length;t=t*2+1){
            if (t+1<length&&arr[t+1]>arr[t]){
                t++;
            }
            if (arr[t]>curVal){
                arr[cur] = arr[t];
                cur=t;
            }
        }
        arr[cur] = curVal;
    }


    public void heapSort07(int[] arr){
        for (int x= (arr.length)/2-1;x>=0;x--){
            heapFy07(arr,x,arr.length);
        }

        for (int x= arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy07(arr,0,x);
        }

    }

    private void heapFy07(int[] arr, int cur, int length) {
        int curVal  = arr[cur];

        for (int t = cur*2+1;t<length;t = t*2+1){
            if (t+1<length && arr[t+1] >arr[t]){
                t = t+1;
            }

            if (arr[t] >curVal){
                arr[cur] = arr[t];
                cur = t;
            }
        }
        arr[cur] = curVal;

    }

    public void heapSort08(int[] arr){
        for (int x=(arr.length/2)-1;x>=0;x--){
            heapFy08(arr,x,arr.length); // 从最后一个非叶子节点开始，
        }

        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x); // 已经堆化
            heapFy08(arr,0,x);
        }
    }

    private void heapFy08(int[] arr, int cur, int length) {
        int curVal = arr[cur];

        for (int t = cur*2+1;t<length;t = t*2+1){
            if (t+1<length && arr[t+1]>arr[t]){
                t = t+1;
            }

            if (arr[t]>curVal){
                arr[cur] = arr[t];
                cur = t;
            }else {
                break;
            }

            arr[cur] = curVal;

        }
    }

    public void heapSort09(int[] arr){
        for (int x= (arr.length/2)-1;x>=0;x--){
            heapFy09(arr,x,arr.length);
        }

        for (int x= arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy09(arr,0,x);
        }
    }

    private void heapFy09(int[] arr, int cur, int length) {
        int curVal = arr[cur];

        for (int t = cur*2+1;t<length;t = t*2+1){
            if (t+1<length && arr[t+1] >arr[t]){
                t++;
            }

            if (arr[t] >curVal){
                arr[cur] = arr[t];
                arr[t] = curVal;
                cur = t;
            }else {
                break;
            }

        }
    }

    public void heapSort10(int[] arr){
        for (int x= (arr.length/2)-1;x>=0;x--){
            heapFy10(arr,x,arr.length);
        }

        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy10(arr,0,x);
        }
    }

    private void heapFy10(int[] arr, int cur, int length) {
//        int curVal = arr[cur];

        for (int t = cur*2+1;t<length;t = t*2+1){
            if(t+1 < length && arr[t+1] >arr[t]){
                t++;
            }

            if (arr[t] >arr[cur]){
                int curVal = arr[cur];
                arr[cur] = arr[t];
                arr[t] = curVal;
                cur = t;
            }else {
                break;
            }

        }
    }

    public void heapSort11(int[]arr){
        for (int x= arr.length/2-1;x>=0;x--){
            heapFy11(arr,x,arr.length);
        }

        for (int x=arr.length-1;x>=0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            heapFy11(arr,0,x);
        }
    }

    private void heapFy11(int[] arr, int cur, int length) {
        for (int t = cur*2+1;t<length;t = t*2+1){
            if (t+1<length && arr[t+1] >arr[t]){
                t++;
            }

            if (arr[t] >arr[cur]){
                int curVal = arr[cur];
                arr[cur] = arr[t];
                arr[t] = curVal;
                cur=t;

            }else {
                break;
            }

        }
    }

    public static void main(String[] args) {
        HeapSortDemo h = new HeapSortDemo();
        MyPrinter.printDefaultArrays(h::heapSort11);
    }
}
