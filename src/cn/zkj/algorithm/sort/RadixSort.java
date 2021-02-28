package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

public class RadixSort {
    //基数排序
    public static void main(String[] args) {
        RadixSort r = new RadixSort();

        MyPrinter.printDefaultArrays(r::radixSort05);
    }

    public void redixSort(int[] arr) {
        //先遍历数组，取出最大的数，算出其位数
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max) {
                max = arr[x];
            }
        }
        //位数n
        int n = 0;
        while (max > 0) {
            max = max / 10;
            n++;
        }
        int[][] bucket = new int[10][arr.length];
        int[] buNum = new int[10];

        for (int x = 0; x < n; x++) {

            for (int y = 0; y < arr.length; y++) {
                int a = arr[y];

                for (int z = 0; z < x; z++) {
                    a = a / 10;
                }
                int b = a % 10;
                bucket[b][buNum[b]] = arr[y];
                buNum[b]++;
            }

            int ax = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < buNum[i]; j++) {
                    arr[ax] = bucket[i][j];
                    ax++;
                }
                buNum[i] = 0;
            }

        }
    }

    //默写
    public void redixSort1(int[] arr) {
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max) {
                max = arr[x];
            }
        }
        int n = 0;//次数,为最大值的位数
        while (max > 0) {
            max /= 10;
            n++;
        }
        //此时，循环次数已经算出
        //先创建出桶
        int[][] bucket = new int[10][arr.length];
        //此数组记录每个桶中有多少个数据
        int[] barrel = new int[10];

        for (int x = 0; x < n; x++) {
            //循环给出的数组，将其按照规则排列进桶中
            for (int y = 0; y < arr.length; y++) {
                //根据当前次数来取数组当前位置的数的 对应位 上的数字,例如，第一次取个位，第二次取十位...
                int cur = arr[y];
                for (int z = 0; z < x; z++) {
                    cur = cur / 10;
                }
                int curLocation = cur % 10;
                //将其对应的放入buket中,例如： 假如当前位置的值为3 ，则将arr【y】 放入 bucket【3】【？】 中,此 ？ 中的值需要去 barrel找
                //例如，3号桶就去 barrel【3】找到其当前储存数据的个数
                bucket[curLocation][barrel[curLocation]] = arr[y];
                //装入桶后，将其的记录值+1；
                barrel[curLocation]++;
            }

            int index = 0;//现在开始需要将桶中的数据放回到arr中，此索引来表示当前放在了arr的什么地方
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < barrel[i]; j++) {
                    arr[index] = bucket[i][j];
                    index++;
                }
                barrel[i] = 0;
            }
        }

    }

    //12.13
    public void redixSort2(int[] arr) {
        int[][] bucket = new int[10][arr.length];
        int[] barrel = new int[10];
        //取出最大值，求出其位数
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            if (arr[x] > max) {
                max = arr[x];
            }
        }
        int n = 0;//次数,为最大值的位数
        while (max > 0) {
            max /= 10;
            n++;
        }


        for (int x = 0; x < n; x++) {
            //开始向桶中依次放入当前位 上的值
            for (int y = 0; y < arr.length; y++) {
                int cur = arr[y];
                for (int z = 0; z < n; z++) {
                    cur = cur / 10;
                }
                cur = cur % 10;
                bucket[cur][barrel[cur]] = arr[y];//bucket[cur][count]=arr[y];

                barrel[cur]++;
            }
            int index = 0;
            for (int i = 0; i < bucket.length; i++) {
                for (int j = 0; j < barrel[i]; j++) {
                    arr[index] = bucket[i][j]; //arr[i]=bucket[i][j];
                    index++;
                }
                barrel[i] = 0;
            }
        }

    }

    public static void radixSort02(int[] arr) {
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            max = Math.max(max, arr[x]);
        }

        int count = String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];

        int[] bucketCount = new int[10];

        for (int x = 0, n = 1; x < count; x++, n *= 10) {
            for (int index = 0; index < arr.length; index++) {
                int cur = (arr[index] / n) % 10;
                buckets[cur][bucketCount[cur]++] = arr[index];
            }
            int arrIndex = 0;
            for (int index = 0; index < 10; index++) {
                int curIndex = bucketCount[index];
                for (int mx = 0; mx < curIndex; mx++) {
                    arr[arrIndex++] = buckets[index][mx];
                }
                bucketCount[index] = 0;
            }

        }
    }

    public void radixSort03(int[] arr) {
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];
        int[] buckteCount = new int[10];

        for (int curP = 0, n = 1; curP < count; curP++, n *= 10) {
            for (int x = 0; x < arr.length; x++) {
                int val = arr[x];
                int radix = val / n % 10;
                buckets[radix][buckteCount[radix]++] = val;
            }
            int arrIndex = 0;
            for (int x = 0; x < 10; x++) {
                int i = buckteCount[x];
                for (int m = 0; m < i; m++) {
                    arr[arrIndex++] = buckets[x][m];
                }
                buckteCount[x] = 0;
            }
        }
    }

    private int getMax(int[] arr) {
        int max = arr[0];
        for (int x = 1; x < arr.length; x++) {
            max = Math.max(max, arr[x]);
        }
        return max;
    }

    public void radixSort04(int[] arr) {
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][] bucktes = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int curP = 0, n = 1; curP < count; curP++, n *= 10) {
            for (int x = 0; x < arr.length; x++) {
                int radix = arr[x] / n % 10;
                bucktes[radix][bucketCounts[radix]++] = arr[x];
            }
            int arrIndex = 0;
            for (int x = 0; x < 10; x++) {
                int bucketCount = bucketCounts[x];
                for (int m = 0; m < bucketCount; m++) {
                    arr[arrIndex++] = bucktes[x][m];
                }
                bucketCounts[x] = 0;
            }
        }
    }

    public void radixSort05(int[] arr) {
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][] bucktes = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int curP = 0, n = 1; curP <= count; curP++, n *= 10) {
            for (int x = 0; x < arr.length; x++) {
                int ordix = arr[x] / n % 10;
                bucktes[ordix][bucketCounts[ordix]++] = arr[x];
            }
            int arrIndex = 0;
            for (int x = 0; x < 10; x++) {
                int bucketCount = bucketCounts[x];
                for (int m = 0; m <bucketCount;m++){
                    arr[arrIndex++] = bucktes[x][m];
                }
                bucketCounts[x] = 0;
            }
        }
    }
}
