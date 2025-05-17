package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

import java.util.Stack;

import static cn.zkj.algorithm.utils.MyPrinter.swap;

public class QuickSort {


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
            // 找寻基准数据的正确索引
            int index = getIndex(arr, low, high);

            // 进行迭代对index之前和之后的数组进行相同的操作使整个数组变成有序
            //quickSort(arr, 0, index - 1); 之前的版本，这种姿势有很大的性能问题，谢谢大家的建议
            quickSort5(arr, low, index - 1);
            quickSort5(arr, index + 1, high);
        }

    }

    private static int getIndex(int[] arr, int low, int high) {
        // 基准数据
        int tmp = arr[low];
        while (low < high) {
            // 当队尾的元素大于等于基准数据时,向前挪动high指针
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            // 如果队尾元素小于tmp了,需要将其赋值给low
            arr[low] = arr[high];
            // 当队首元素小于等于tmp时,向前挪动low指针
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            // 当队首元素大于tmp时,需要将其赋值给high
            arr[high] = arr[low];

        }
        // 跳出循环时low和high相等,此时的low或high就是tmp的正确索引位置
        // 由原理部分可以很清楚的知道low位置的值并不是tmp,所以需要将tmp赋值给arr[low]
        arr[low] = tmp;
        return low; // 返回tmp的正确位置
    }

    //20210223  01
    public static void myQuickSort(int[] arr, int low, int high) {
        int left = low;
        int right = high;


        if (low < high) {
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
    public static void myQuickSort2(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex2(arr, low, high);

            myQuickSort2(arr, low, index - 1);
            myQuickSort2(arr, index + 1, high);
        }
    }

    private static int getIndex2(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public void quickSort03(int[] arr) {
        quickSort03(arr, 0, arr.length - 1);
    }

    private void quickSort03(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot03(arr, left, right);
            quickSort03(arr, left, pivot - 1);
            quickSort03(arr, pivot + 1, right);
        }
    }

    private int getPivot03(int[] arr, int left, int right) {
        int tmp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    public static void quickSort04(int[] arr) {
        quickSort04(arr, 0, arr.length - 1);
    }

    private static void quickSort04(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot04(arr, left, right);
            quickSort04(arr, left, pivot - 1);
            quickSort04(arr, pivot + 1, right);
        }
    }

    private static int getPivot04(int[] arr, int left, int right) {
        int tmp = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = tmp;
        return left;
    }

    public void quickSort05(int[] arr) {
        quickSort05(arr, 0, arr.length - 1);
    }

    private void quickSort05(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot(arr, left, right);
            quickSort05(arr, left, pivot);
            quickSort05(arr, pivot + 1, right);
        }
    }

    private int getPivot(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    /**
     * 快速排序  判断交换的时候，只有大于小于，没有等于。造成了死循环
     *
     * @param arr
     */
    public void quickSort06(int[] arr) {
        quickSort06(arr, 0, arr.length - 1);
    }

    private void quickSort06(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot06(arr, left, right);
            quickSort06(arr, left, pivot);
            quickSort06(arr, pivot + 1, right);
        }
    }

    private int getPivot06(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    public void quickSort07(int[] arr) {
        quick07(arr, 0, arr.length - 1);
    }

    private void quick07(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivor07(arr, left, right);
            quick07(arr, left, pivot);
            quick07(arr, pivot + 1, right);
        }
    }

    private int getPivor07(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }

        arr[left] = tmp;
        return left;
    }

    public void quickSort08(int[] arr) {
        quick08(arr, 0, arr.length - 1);
    }

    private void quick08(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot08(arr, left, right);
            quick08(arr, left, pivot);
            quick08(arr, pivot + 1, right);
        }
    }

    private int getPivot08(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = tmp;
        return left;
    }

    public void quickSort09(int[] arr) {
        quick09(arr, 0, arr.length - 1);
    }

    private void quick09(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot09(arr, left, right);
            quick09(arr, left, pivot);
            quick09(arr, pivot + 1, right);
        }
    }

    private int getPivot09(int[] arr, int left, int right) {
        int tmp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= tmp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= tmp) {
                left++;
            }
            arr[right] = arr[left];


        }
        arr[left] = tmp;
        return left;
    }

    private void quickSort10(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length - 1);
        stack.push(0);


        while (!stack.isEmpty()) {
            int l = stack.pop();
            int r = stack.pop();
            if (l >= r) {
                continue;
            }
            int left = l;
            int right = r;
            int p = arr[left];
            while (left < right) {
                while (left < right && arr[right] >= p) {
                    right--;
                }
                arr[left] = arr[right];
                while (left < right && arr[left] <= p) {
                    left++;
                }
                arr[right] = arr[left];
            }
            arr[left] = p;
            stack.push(r);
            stack.push(right + 1);
            stack.push(right);
            stack.push(l);
        }
    }

    public void quickSort11(int[] arr) {
        quick11(arr, 0, arr.length - 1);
    }

    private void quick11(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot11(arr, left, right);
            quick11(arr, left, pivot);
            quick11(arr, pivot + 1, right);
        }
    }

    private int getPivot11(int[] arr, int left, int right) {
        int p = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= p) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= p) {
                left++;
            }
            arr[right] = arr[left];

        }

        arr[left] = p;
        return left;
    }

    public void quickSort12(int[] arr) {
        quick12(arr, 0, arr.length - 1);
    }

    private void quick12(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot12(arr, left, right);
            quick12(arr, left, pivot);
            quick12(arr, pivot + 1, right);
        }
    }

    private int getPivot12(int[] arr, int left, int right) {
        int p = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= p) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= p) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = p;
        return left;
    }

    public void quickSort13(int[] arr) {
        quick13(arr, 0, arr.length - 1);
    }

    private void quick13(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot13(arr, left, right);
            quick13(arr, left, pivot);
            quick13(arr, pivot + 1, right);
        }
    }

    private int getPivot13(int[] arr, int left, int right) {
        int p = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= p) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= p) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = p;
        return left;
    }

    public void quickSort14(int[] arr) {
        quick14(arr, 0, arr.length - 1);
    }

    private void quick14(int[] arr, int left, int right) {
        if (left < right) {
            int pivot = getPivot18(arr, left, right);
            quick14(arr, left, pivot);
            quick14(arr, pivot + 1, right);
        }
    }

    private int getPivot18(int[] arr, int left, int right) {
        int t = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= t) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= t) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = t;
        return left;
    }

    public void quickSort0517(int[] nums) {
        quickSort0517(nums, 0, nums.length - 1);
    }
    public void quickSort0517(int[] nums, int l, int r) {
        if (l < r) {
            int pivot = getPivot0517(nums, l , r);
            quickSort0517(nums, l, pivot);
            quickSort0517(nums, pivot + 1, r);
        }
    }

    private int getPivot0517(int[] nums, int l, int r) {
        while (l < r) {
            while (l < r && nums[l] <= nums[r]) {
                l++;
            }
            swap(nums, l , r);
            while (l < r && nums[l] <= nums[r]) {
                r--;
            }
            swap(nums, l , r);
        }
        return l;
    }


    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        MyPrinter.printDefaultArrays(q::quickSort0517);
    }
}
