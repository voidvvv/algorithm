package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

import java.util.Stack;

public class MergeSort {

    //分+合
    public void divide(int[] arr, int left, int right, int[] temp) {

        if (left < right) {
            int mid = (left + right) / 2;
            divide(arr, left, mid, temp);
            divide(arr, mid + 1, right, temp);
            merge(arr, left, mid, right, temp);

        }
    }

    //合
    public void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int t = 0;

        //1，先吧左右两边的数组按照顺序放入临时数组中，直到两边的有序数组，有一组放入完毕
        while (i <= mid && j <= right) {
            if (arr[i] >= arr[j]) {
                temp[t] = arr[j];
                t++;
                j++;
            } else {
                temp[t] = arr[i];
                t++;
                i++;
            }
        }

        //2.将剩余数组的剩下部分全部放入temp中
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //3.将temp数组元素拷贝到arr中
        //不是每次都拷贝
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            arr[tempLeft] = temp[t];

            t++;
            tempLeft++;


        }


    }

    //归并排序 12.11
    //合
    public void merge1(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;

        int t = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }
        }
        //将剩余数组中的部分全部放入temp中
        while (i <= mid) {
            temp[t] = arr[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            j++;
            t++;
        }

        //将temp放入arr中
        t = 0;
        int indexLeft = left;

        while (indexLeft <= right) {
            arr[indexLeft] = temp[t];
            t++;
            indexLeft++;
        }

    }

    //分
    public void divide1(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide1(arr, left, mid, temp);
            divide1(arr, mid + 1, right, temp);
            merge1(arr, left, mid, right, temp);
        }
    }

    //12.13
    //合
    public void merge2(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        //1,不断从两边取值，找到较小的放入
        int t = 0;
        while (i <= mid & j <= right) {
            if (arr[i] <= arr[j]) {
                temp[t] = arr[i];
                i++;
                t++;
            } else {
                temp[t] = arr[j];
                j++;
                t++;
            }

        }

        //2，将剩余的全部按顺序放入temp
        while (i <= mid) {
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j <= right) {
            temp[t] = arr[j];
            t++;
            j++;
        }

        //将temp放入原数组
        t = 0;
        int leftIndex = left;
        while (leftIndex <= right) {
            arr[leftIndex] = temp[t];
            t++;
            leftIndex++;
        }
    }

    //分
    public void divide2(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide2(arr, left, mid, temp);
            divide2(arr, mid + 1, right, temp);

            merge2(arr, left, mid, right, temp);
        }
    }

    public void mergeSort04(int[] arr) {
        int[] tmp = new int[arr.length];
        divide04(arr, 0, arr.length - 1, tmp);
    }

    private void divide04(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (right + left) / 2;
            divide04(arr, left, mid, tmp);
            divide04(arr, mid + 1, right, tmp);
            merge04(arr, left, mid, right, tmp);
        }
    }

    private void merge04(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexL = left;
        int indexR = mid + 1;
        int concur = 0;
        while (indexL <= mid && indexR <= right) {
            if (arr[indexL] < arr[indexR]) {
                tmp[concur++] = arr[indexL++];
            } else {
                tmp[concur++] = arr[indexR++];
            }
        }

        while (indexL <= mid) {
            tmp[concur++] = arr[indexL++];
        }
        while (indexR <= right) {
            tmp[concur++] = arr[indexR++];
        }
        concur = 0;

        while (left <= right) {
            arr[left++] = tmp[concur++];
        }
    }

    public void mergeSort05(int[] arr) {
        int[] tmp = new int[arr.length];
        divide05(arr, 0, arr.length - 1, tmp);
    }

    private void divide05(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide05(arr, left, mid, tmp);
            divide05(arr, mid + 1, right, tmp);
            merge05(arr, left, mid, right, tmp);
        }
    }

    private void merge05(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexL = left;
        int indexR = mid + 1;

        int t = 0;

        while (indexL <= mid && indexR <= right) {
            if (arr[indexL] < arr[indexR]) {
                tmp[t++] = arr[indexL++];
            } else {
                tmp[t++] = arr[indexR++];
            }
        }

        while (indexL <= mid) {
            tmp[t++] = arr[indexL++];
        }
        while (indexR <= right) {
            tmp[t++] = arr[indexR++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

    /**
     * 归并排序
     *
     * @param arr
     */
    public void mergeSort06(int[] arr) {
        int[] tmp = new int[arr.length];
        divide06(arr, 0, arr.length - 1, tmp);
    }

    private void divide06(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide06(arr, left, mid, tmp);
            divide06(arr, mid + 1, right, tmp);
            merge06(arr, left, mid, right, tmp);
        }
    }

    private void merge06(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexL = left;
        int indexR = mid + 1;

        int t = 0;
        while (indexL <= mid && indexR <= right) {
            if (arr[indexL] < arr[indexR]) {
                tmp[t++] = arr[indexL++];
            } else {
                tmp[t++] = arr[indexR++];
            }
        }
        while (indexL <= mid) {
            tmp[t++] = arr[indexL++];
        }
        while (indexR <= right) {
            tmp[t++] = arr[indexR++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

    public void mergeSort07(int[] arr) {
        int[] tmp = new int[arr.length];
        divide07(arr, 0, arr.length - 1, tmp);
    }

    private void divide07(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide07(arr, left, mid, tmp);
            divide07(arr, mid + 1, right, tmp);
            merge07(arr, left, mid, right, tmp);
        }
    }

    private void merge07(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexL = left;
        int indexR = mid + 1;

        int t = 0;
        while (indexL <= mid && indexR <= right) {
            if (arr[indexL] < arr[indexR]) {
                tmp[t++] = arr[indexL++];
            } else {
                tmp[t++] = arr[indexR++];
            }
        }
        while (indexL <= mid) {
            tmp[t++] = arr[indexL++];
        }
        while (indexR <= right) {
            tmp[t++] = arr[indexR++];
        }
        t = 0;
        while (left <= right) {
            arr[left++] = tmp[t++];
        }
    }

    public void mergeSort08(int[] arr) {
        divide08(arr, 0, arr.length - 1, new int[arr.length]);
    }

    private void divide08(int[] arr, int left, int right, int[] tmp) {
        if (left < right) {
            int mid = (left + right) / 2;
            divide08(arr, left, mid, tmp);
            divide08(arr, mid + 1, right, tmp);
            merge08(arr, left, mid, right, tmp);
        }
    }

    private void merge08(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexL = left;
        int indexR = mid + 1;

        int t = 0;
        while (indexL <= mid && indexR <= right) {
            if (arr[indexL] < arr[indexR]) {
                tmp[t++] = arr[indexL++];
            } else {
                tmp[t++] = arr[indexR++];
            }
        }
        while (indexL <= mid) {
            tmp[t++] = arr[indexL++];
        }
        while (indexR <= right) {
            tmp[t++] = arr[indexR++];
        }
        t=0;
        while (left<=right){
            arr[left++] = tmp[t++];
        }
    }

    public void mergeSort09(int[] arr){
        int[] tmp = new int[arr.length];
        divide09(arr,0,arr.length-1,tmp);
    }

    private void divide09(int[] arr, int left, int right, int[] tmp) {
        if (left<right){
            int mid = (left+right)/2;
            divide09(arr,left,mid,tmp);
            divide09(arr,mid+1,right,tmp);
            merge09(arr,left,mid,right,tmp);
        }
    }

    private void merge09(int[] arr, int left, int mid, int right, int[] tmp) {
        int leftIndex = left;
        int rightIndex = mid+1;
        int t = 0;
        while (leftIndex<=mid && rightIndex<=right){
            if (arr[leftIndex]<arr[rightIndex]){
                tmp[t++] = arr[leftIndex++];
            }else {
                tmp[t++] = arr[rightIndex++];
            }
        }

        while (leftIndex<=mid){
            tmp[t++] = arr[leftIndex++];
        }
        while (rightIndex<=right){
            tmp[t++] = arr[rightIndex++];
        }

        t=0;
        while (left<=right){
            arr[left++] = tmp[t++];
        }
    }

    public void mergeSort10(int[] arr){
        int[] tmp = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(arr.length-1);

        while (!stack.empty()){
            int right = stack.pop();
            int left = stack.pop();


        }

    }

    private void divide10(int[] arr, int left, int right, int[] tmp) {

        if (left<right){
            int mid = (right+left)/2;

        }
    }


    public void mergeSort11(int[] arr){
        divide11(arr,0,arr.length-1,new int[arr.length]);
    }

    private void divide11(int[] arr, int left, int right, int[] tmp) {
        if (left<right){
            int mid = (left+right)/2;

            divide(arr,left,mid,tmp);
            divide(arr,mid+1,right,tmp);
            merge11(arr,left,mid,right,tmp);
        }
    }

    private void merge11(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexLeft = left;
        int indexRight = mid+1;

        int t = 0;

        while (indexLeft<=mid && indexRight <=right){
            if (arr[indexLeft]<arr[indexRight]){
                tmp[t++] = arr[indexLeft++];
            }else {
                tmp[t++] = arr[indexRight++];
            }
        }

        while (indexLeft<=mid){
            tmp[t++] = arr[indexLeft++];
        }

        while (indexRight <=right){
            tmp[t++] = arr[indexRight++];
        }

        t = 0;

        while (left<=right){
            arr[left++] = tmp[t++];
        }
    }

    public void mergeSort12(int[] arr){
        divide12(arr,0,arr.length-1,new int[arr.length]);
    }

    private void divide12(int[] arr, int left, int right,int[] tmp) {
        if (left<right){
            int mid = (left+right)/2;
            divide12(arr,left,mid,tmp);
            divide12(arr,mid+1,right,tmp);
            merge12(arr,left,mid,right,tmp);
        }
    }

    private void merge12(int[] arr, int left, int mid, int right, int[] tmp) {
        int leftIndex = left;
        int rightIndex = mid+1;
        int t =0;

        while (leftIndex<=mid && rightIndex<=right){
            if (arr[leftIndex]<=arr[rightIndex]){
                tmp[t++] = arr[leftIndex++];
            }else {
                tmp[t++] = arr[rightIndex++];
            }
        }

        while (leftIndex<=mid ){
            tmp[t++] = arr[leftIndex++];
        }

        while (rightIndex<=right){
            tmp[t++] = arr[rightIndex++];
        }
        t = 0;

        while (left<=right){
            arr[left++] = tmp[t++];
        }
    }

    public void mergeSort13(int[] arr){
        divide13(arr,0,arr.length-1,new int[arr.length]);
    }

    private void divide13(int[] arr, int left, int right, int[] tmp) {
        if (left<right){
            int mid = (left+right)/2;
            divide13(arr,left,mid,tmp);
            divide13(arr,mid+1,right,tmp);
            merge13(arr,left,mid,right,tmp);
        }
    }

    private void merge13(int[] arr, int left, int mid, int right, int[] tmp) {
        int indexLeft = left;
        int indexRight = mid+1;
        int t = 0;

        while (indexLeft<=mid && indexRight<=right){
            if (arr[indexLeft]<arr[indexRight]){
                tmp[t++] = arr[indexLeft++];
            }else {
                tmp[t++] = arr[indexRight++];
            }

        }

        while (indexLeft<=mid){
            tmp[t++] = arr[indexLeft++];
        }
        while (indexRight<=right) {
            tmp[t++] = arr[indexRight++];
        }

        t = 0;
        while (left<=right){
            arr[left++] = tmp[t++];
        }
    }

    public static void main(String[] args) {
        MergeSort q = new MergeSort();
        MyPrinter.printDefaultArrays(q::mergeSort13);
    }

}
