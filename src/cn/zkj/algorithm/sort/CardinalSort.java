package cn.zkj.algorithm.sort;

import cn.zkj.algorithm.utils.MyPrinter;

/**
 * @Classname CardinalSort
 * @Description
 * @Date 2022/2/19 17:02
 * @Created by zkj
 */
public class CardinalSort {

    public void cardinalSort01(int arr[]){
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];
        int[] cardinalCount = new int[10];

        for (int curP = 0,n=1;curP<count;curP++,n*=10){
            for (int x=0;x<arr.length;x++){
                int radix = arr[x]/n%10;
                buckets[radix][cardinalCount[radix]++] = arr[x];
            }
            int arrIndex = 0;
            for (int x=0;x<10;x++){
                int curCarCount = cardinalCount[x];
                for (int m=0;m<curCarCount;m++){
                    arr[arrIndex++] = buckets[x][m];
                }
                cardinalCount[x] = 0;
            }

        }

    }

    private int getMax(int[] arr) {
        int max= arr[0];
        for (int x=1;x<arr.length;x++){
            if (max<arr[x]){
                max = arr[x];
            }
        }
        return max;
    }

    public void cardinalSort(int[] arr){
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];
        int[] bucketCount = new int[10];
        for (int curP = 0,n=1;curP<count;curP++,n*=10){
            for (int x=0;x<arr.length;x++){
                int cardinal = arr[x]/n%10;
                buckets[cardinal][bucketCount[cardinal]++] = arr[x];
            }
            int arrIndex = 0;
            for (int x =0;x<10;x++){
                int cMax = bucketCount[x];
                for (int y=0;y<cMax;y++){
                    arr[arrIndex++] = buckets[x][y];
                }
                bucketCount[x] = 0;
            }

        }

    }

    public void  cardinalSort02(int[] arr){
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][]buckets = new int[10][arr.length];
        int[] bucketCount = new int[10];

        for (int curP=0,n=1;curP<count;curP++,n*=10){
            for (int x=0;x<arr.length;x++){
                int cardinal = (arr[x]/n)%10;
                buckets[cardinal][bucketCount[cardinal]++] = arr[x];
            }
            int arrIndex = 0;
            for (int cardi= 0;cardi<10;cardi++){
                int cnt = bucketCount[cardi];

                for (int m =0;m<cnt;m++){
                    arr[arrIndex++] = buckets[cardi][m];
                }
                bucketCount[cardi] = 0;
            }
        }

    }

    public void cardinalSort03(int[] arr){
        int max = getMax(arr);

        int c= String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int curP = 0,n=1;curP<c;curP++,n*=10){
            for (int x=0;x<arr.length;x++){
                int cardinal = arr[x]/n%10;
                buckets[cardinal][bucketCounts[cardinal]++] = arr[x];
            }
            int arrIndex = 0;

            for (int m = 0;m<10;m++){
                int bc = bucketCounts[m];
                for (int x=0;x<bc;x++){
                    arr[arrIndex++] = buckets[m][x];
                }
                bucketCounts[m] = 0;
            }

        }
    }

    public void cardinalSort04(int[] arr){
        int max = getMax(arr);
        int c = String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int curP = 0,n=1;curP<c;curP++,n*=10){
            for (int x=0;x<arr.length;x++){
                int cardinal = arr[x]/n%10;
                buckets[cardinal][bucketCounts[cardinal]++] =arr[x];
            }
            int arrIndex = 0;
            for (int car =0;car<10;car++){
                int cnt = bucketCounts[car];
                for (int t = 0;t<cnt;t++){
                    arr[arrIndex++] = buckets[car][t];
                }
                bucketCounts[car] = 0;
            }
        }
    }

    public void cardinalSort05(int[] arr){
        int max = getMax(arr);
        int count = String.valueOf(max).length();

        int[][] buckets = new int[10][arr.length];
        int[] bucketCounts = new int[10];

        for (int curP =0,n=1;curP<count;curP++,n*=10){
            for (int x=0;x<arr.length;x++){
                int cardinal = arr[x]/n%10;
                buckets[cardinal][bucketCounts[cardinal]++] = arr[x];
            }
            int arrIndex = 0;

            for (int t =0;t<10;t++){
                int c = bucketCounts[t];
                for (int x=0;x<c;x++){
                    arr[arrIndex++] = buckets[t][x];
                }
                bucketCounts[t] = 0;
            }
        }
    }

    public static void main(String[] args) {
        CardinalSort cardinalSort = new CardinalSort();
        MyPrinter.printDefaultArrays(cardinalSort::cardinalSort05);
    }
}
