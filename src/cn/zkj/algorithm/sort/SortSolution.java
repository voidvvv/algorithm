package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyArraysUtil;

import java.util.Arrays;

/**
 * 排序方法汇总。以下均为以从小到大排序为依据
 *
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/2/21
 * @version: 01
 */
public class SortSolution {
    public static void main(String[] args) {
        int[] ints = MyArraysUtil.newArray(20, 20);
        Arrays.sort(new double[2]);
        System.out.println(Arrays.toString(ints));
        insertOrder(ints);
        System.out.println(Arrays.toString(ints));


    }

    /**
     * 冒泡排序
     * <p>
     * 从头开始，两两交换，按照预定的排序顺序，将较大（较小的）放在后面，直到遍历所有元素
     *
     * @param arr
     */
    //冒泡排序方法，以升序排序为例子：
    public void bubbleSort2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        for (int x = 1; x < arr.length; x++) {
            for (int y = 0; y < arr.length - x; y++) {
                if (arr[y] > arr[y + 1]) {
                    swap(arr, y, y + 1);
                }
            }
        }
    }

    private void swap(int[] arr, int y, int i) {
        int i1 = arr[y];
        arr[y] = arr[i];
        arr[i] = i1;

    }

    /**
     * 选择排序
     * <p>
     * 先按照排序顺序，选取所需要的元素，然后将其放在前面已排序好的元素序列后面
     *
     * @param arr
     */
    public void selectOrder(int[] arr) {

        for (int index = 0; index < arr.length; index++) {
            int minTemp = arr[index];
            int minIndex = index;
            for (int x = index + 1; x < arr.length; x++) {
                if (minTemp > arr[x]) {
                    minTemp = arr[x];
                    minIndex = x;
                }

            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = temp;
        }
    }

    /**
     * 插入排序
     * <p>
     * 对欲排序的元素，以插入的方式寻找其合适的位置。
     * 个人理解：插入排序其实就是选择排序的变种。选择排序是先选择合适的元素，放在当前位置。
     * 而插入排序，则是直接找当前位置的元素，插入到顺序表合适的位置
     *
     * @param arr
     */
    public static void insertOrder(int[] arr) {
        //省略判断数组有效性步骤

        for (int x = 1; x < arr.length; x++) {
            int cur = arr[x];
            int y = x-1;
            for (; y >=0; y--) {
                if (arr[y] > cur) {
                    arr[y+1] = arr[y];
                }else {
                    break;
                }
            }
            arr[y+1]=cur;
        }
    }

    /**
     * 希尔排序（插入排序变种）
     * <p>
     * 为了改善插入排序的一些弊端。比如原数组本来在前面就有很多的有序元素，插入排序前面的很多遍历就都成为了徒劳，对程序的浪费
     * 希尔排序会将集合先进行分组，先按每组来排序，然后减小分组，继续进行插入排序。直至分组数小于0
     * [4, 2, 17, 3, 85, 0, 31, 2, 7, 61, 43, 87, 31, 39, 38, 42, 72, 24, 20, 55]
     * 20个元素，首先分10组，其中，下标位0，10是一组，1，11 是一组，2，12是一组，。。。
     * 第二次，分5组，下表0，5，10，15为一组，1，6，11，16是一组。。。。
     * 第三次，分2组，下表0，2，4，6，8，10，12，14，16，18为一组，1，3，5，7，9，11，13，15，17，19 为一组
     * 最后分组数为1，进行整体插入排序
     *
     * @param arr
     */
    public static void shellOrder(int[] arr) {
        int buc = arr.length / 2;
        while (buc > 0) {
            for (int x = buc; x < arr.length; x++) {
                int cur = arr[x];
                int y = x - buc;
                for (; y >= 0; y -= buc) {
                    if (arr[y] > cur) {
                        int temp = arr[y];
                        arr[y+buc] = temp;
                        arr[y] = cur;

                    }else {
                        break;
                    }
                }
                arr[y+buc] = cur;
            }
            buc = buc / 2;
        }
    }

    /**
     * 快速排序 (冒泡排序改进)
     *
     *
     * @param arr
     */
    public static void quickOrder(int[] arr) {
        quickSort(arr,0,arr.length-1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        if (low<high){
            int temp = arr[low];//基准值
            while (low<high){
                while (low<high&&arr[high]>=temp){
                    high--;
                }

                arr[low] = arr[high];

                while (low<high&&arr[low]<=temp){
                    low++;
                }
                arr[high] = arr[low];
            }
            //此时，low与high是相等的。并且该值为temp所应该在的位置
            arr[low] = temp;
            //此时，基准值low左边的所有元素，理论上都比右边的所有元素要小,此时再分别对low左右两边进行快排即可
            quickSort(arr,left,low-1);
            quickSort(arr,low+1,right);

        }
    }

    /**
     * 归并排序
     * @param arr
     */
    public void mergeOrder(int[] arr){
        //使用递归进行分
        radixOrder(arr,0,arr.length-1,new int[arr.length]);
    }

    private static void radixOrder(int[] arr,int left,int right,int []temp){
        if (left<right){
            int mid = (left+right)/2;
            radixOrder(arr,left,mid,temp);
            radixOrder(arr,mid+1,right,temp);
            merge(arr,left,right,mid,temp);
        }
    }

    private static void merge(int[] arr,int left,int right,int mid,int[] temp){
        int lstart = left;
        int rstart = mid+1;

        int t =0;

        while (lstart<=mid&&rstart<=right){
            if (arr[lstart]<arr[rstart]){
                temp[t++] = arr[lstart++];
            }else {
                temp[t++] = arr[rstart++];
            }
        }

        while (lstart<=mid){
            temp[t++] = arr[lstart++];
        }

        while (rstart<=right){
            temp[t++] = arr[rstart++];
        }

        t=0;
        while (left<=right){
            arr[left++] = temp[t++];
        }
    }

    /**
     * 基数排序
     * @param arr
     */
    public static void radixOrder(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int x=0;x<arr.length;x++){
            max = Math.max(max,arr[x]);
        }
        int count = String.valueOf(max).length();
        int[][] bucket = new int[10][arr.length];

        int[] bucketCount = new int[10];
        for (int x=1,n=1;x<=count;x++,n*=10){
            for (int index=0;index<arr.length;index++){
                int cur = (arr[index]/n) %10;

                    bucket[cur][bucketCount[cur]++] = arr[index];

            }
            int arrIndex = 0;
            for (int index=0;index<10;index++){
                int curCount = bucketCount[index];
                int[] b =bucket[index];
                for (int in=0;in<curCount;in++){
                    arr[arrIndex++] = b[in];
                }
                bucketCount[index] = 0;
            }


        }
    }


    /**
     * 堆排序  2021/2/24 手撕堆排序
     * @param arr
     */
    public static void heapOrder(int[] arr){
        for (int x=(arr.length/2)-1;x>=0;x--){
            treeFy01(arr,x,arr.length);
        }

        for (int x=arr.length-1;x>0;x--){
            MyArraysUtil.swapVal(arr,0,x);
            treeFy01(arr,0,x-1);
        }

    }

    private static void treeFy01(int[] arr, int start, int length) {
        for (int target = 2*start+1;target<length;target = target*2+1){
            if (target<length-1&&arr[target]<arr[target+1]){
                target++;
            }

            if (arr[start]<arr[target]){
                MyArraysUtil.swapVal(arr,start,target);
                start = target;
            }
        }
    }
}
