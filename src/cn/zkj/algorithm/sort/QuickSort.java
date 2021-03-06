package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

public class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        MyPrinter.printDefaultArrays(q::quickSort08);

    }

    //12.10
    public void quickSort(int[] arr, int left, int right) {
        int le = left;
        int r = right;

        int pivot = (left + right) / 2;
        int pval = arr[pivot];

        while (le < r) {
            while (arr[le] < pval) {
                le++;
            }
            while (arr[r] > pval) {
                r--;
            }

            if (le >= r) {
                break;
            }

            int temp = arr[le];
            arr[le] = arr[r];
            arr[r] = temp;

            if (arr[le] == pval) {
                r--;
            }
            if (arr[r] == pval) {
                le++;
            }


        }
        if (r == le) {
            le++;
            r--;
        }
        if (le < right) {
            quickSort(arr, le, right);
        }

        if (left < r) {
            quickSort(arr, left, r);
        }
    }

    //12.10
    public void quickSort2(int[] arr, int left, int right) {
        int le = left;
        int r = right;

        int pivot = arr[(left + right) / 2];
        while (le < r) {
            while (arr[le] < pivot) {
                le++;
            }
            while (arr[r] > pivot) {
                r--;
            }

            if (le >= r) {
                break;
            }

            int temp = arr[le];
            arr[le] = arr[r];
            arr[r] = temp;

            if (arr[le] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                le++;
            }
        }
        if (le == r) {
            le++;
            r--;
        }
        if (r > left) {
            quickSort2(arr, left, r);
        }
        if (le < right) {
            quickSort2(arr, le, right);
        }


    }

    //12.11
    public void quickSort3(int[] arr, int left, int right) {
        int le = left;
        int r = right;

        int pivot = arr[(left + right) / 2];
        int temp = 0;
        while (le < r) {
            while (arr[le] < pivot) {
                le++;
            }
            while (arr[r] > pivot) {
                r--;
            }

            if (le >= r) {
                break;
            }
            temp = arr[le];
            arr[le] = arr[r];
            arr[r] = temp;

            if (arr[le] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                le++;
            }

        }
        if (le == r) {
            le++;
            r--;
        }

        if (le < right) {
            quickSort3(arr, le, right);
        }
        if (r > left) {
            quickSort3(arr, left, r);
        }
    }

    public void quickSort4(int[] arr, int left, int right) {
        int le = left;
        int r = right;

        int pivot = arr[(left + right) / 2];
        int temp;
        while (le < r) {
            while (arr[le] < pivot) {
                le++;
            }
            while (arr[r] > pivot) {
                r--;
            }

            if (le >= r) {
                break;
            }

            temp = arr[le];
            arr[le] = arr[r];
            arr[r] = temp;

            if (arr[le] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                le++;
            }
        }
        if (le == r) {
            le++;
            r--;
        }
        if (le < right) {
            quickSort4(arr, le, right);
        }
        if (r > left) {
            quickSort4(arr, left, r);
        }
    }


    public void quickSort5(int[] arr, int low, int high) {

        if (low < high) {
            // ?????????????????????????????????
            int index = getIndex(arr, low, high);

            // ???????????????index????????????????????????????????????????????????????????????????????????
            //quickSort(arr, 0, index - 1); ??????????????????????????????????????????????????????????????????????????????
            quickSort5(arr, low, index - 1);
            quickSort5(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // ????????????
        int tmp = arr[low];
        while (low < high) {
            // ?????????????????????????????????????????????,????????????high??????
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // ????????????????????????tmp???,?????????????????????low
            arr[low] = arr[high];
            // ???????????????????????????tmp???,????????????low??????
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // ?????????????????????tmp???,?????????????????????high
            arr[high] = arr[low];

        }
        // ???????????????low???high??????,?????????low???high??????tmp?????????????????????
        // ???????????????????????????????????????low?????????????????????tmp,???????????????tmp?????????arr[low]
        arr[low] = tmp;
        return low; // ??????tmp???????????????
    }

    //20210223  01
    public static void myQuickSort(int[] arr,int low,int high){
        int left = low;
        int right = high;



        if (low<high) {
            int temp = arr[left];
            while (left < right) {
                while (left < right && arr[right] >= temp) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= temp) {
                    left++;
                }
                arr[right] = arr[left];

            }

            arr[left] = temp;

            myQuickSort(arr, low, left - 1);
            myQuickSort(arr, left + 1, high);
        }
    }


    //20210223  02
    public static void myQuickSort2(int[] arr,int low,int high){
        if (low<high){
            int index = getIndex2(arr,low,high);

            myQuickSort2(arr,low,index-1);
            myQuickSort2(arr,index+1,high);
        }
    }

    private static int getIndex2(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low<high){
            while (low<high&&arr[high]>=temp){
                high--;
            }
            arr[low] = arr[high];
            while (low<high&&arr[low]<=temp){
                low++;
            }
            arr[high] =arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public void quickSort03(int[]arr){
        quickSort03(arr,0,arr.length-1);
    }

    private void quickSort03(int[] arr, int left, int right) {
        if (left<right){
            int pivot = getPivot03(arr,left,right);
            quickSort03(arr,left,pivot-1);
            quickSort03(arr,pivot+1,right);
        }
    }

    private int getPivot03(int[] arr, int left, int right) {
        int tmp = arr[left];

        while (left<right){
            while (left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    public static void quickSort04(int[] arr){
        quickSort04(arr,0,arr.length-1);
    }

    private static void quickSort04(int[] arr, int left, int right) {
        if (left<right){
            int pivot = getPivot04(arr,left,right);
            quickSort04(arr,left,pivot-1);
            quickSort04(arr,pivot+1,right);
        }
    }

    private static int getPivot04(int[] arr, int left, int right) {
        int tmp = arr[left];

        while (left<right){
            while (left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=tmp){
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = tmp;
        return left;
    }

    public void quickSort05(int[]arr){
        quickSort05(arr,0,arr.length-1);
    }

    private void quickSort05(int[] arr, int left, int right) {
        if (left<right){
            int pivot = getPivot(arr,left,right);
            quickSort05(arr,left,pivot);
            quickSort05(arr,pivot+1,right);
        }
    }

    private int getPivot(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    /**
     * ????????????  ??????????????????????????????????????????????????????????????????????????????
     * @param arr
     */
    public void quickSort06(int[] arr){
        quickSort06(arr,0,arr.length-1);
    }

    private void quickSort06(int[] arr, int left, int right) {
        if (left<right){
            int pivot = getPivot06(arr,left,right);
            quickSort06(arr,left,pivot);
            quickSort06(arr,pivot+1,right);
        }
    }

    private int getPivot06(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    public void quickSort07(int[] arr){
        quick07(arr,0,arr.length-1);
    }

    private void quick07(int[] arr, int left, int right) {
        if (left<right){
            int pivot = getPivor07(arr,left,right);
            quick07(arr,left,pivot);
            quick07(arr,pivot+1,right);
        }
    }

    private int getPivor07(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=tmp){
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = tmp;
        return left;
    }

    public void quickSort08(int[] arr){
        quick08(arr,0,arr.length-1);
    }

    private void quick08(int[] arr, int left, int right) {
        if (left<right){
            int pivot = getPivot08(arr,left,right);
            quick08(arr,left,pivot);
            quick08(arr,pivot+1,right);
        }
    }

    private int getPivot08(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left<right){
            while (left<right&&arr[right]>=tmp){
                right--;
            }
            arr[left] = arr[right];
            while (left<right&&arr[left]<=tmp){
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

}
