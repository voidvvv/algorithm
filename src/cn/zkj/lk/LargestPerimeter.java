package cn.zkj.lk;

import java.util.Arrays;

/*
976. 三角形的最大周长
给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。

如果不能形成任何面积不为零的三角形，返回 0。
 */
public class LargestPerimeter {
    public static void main(String[] args) {
        int[] a={5,1,2,3,1,2,7,8,9,545,2,3,47886,1,2145,4};


    }
    public int largestPerimeter(int[] A) {
        Arrays.sort(A);
        int length = A.length;
        for (int x=length-1;x>1;x--){
            if (A[x-1]+A[x-2]>A[x]){
                return A[x-1]+A[x-2]+A[x];
            }

        }
        return 0;
    }
}
