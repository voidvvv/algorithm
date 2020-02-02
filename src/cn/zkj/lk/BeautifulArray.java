package cn.zkj.lk;

import java.util.Arrays;

/*
932. 漂亮数组
对于某些固定的 N，如果数组 A 是整数 1, 2, ..., N 组成的排列，使得：

对于每个 i < j，都不存在 k 满足 i < k < j 使得 A[k] * 2 = A[i] + A[j]。

那么数组 A 是漂亮数组。

 

给定 N，返回任意漂亮数组 A（保证存在一个）。

 

示例 1：

输入：4
输出：[2,1,4,3]
示例 2：

输入：5
输出：[3,1,2,5,4]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/beautiful-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BeautifulArray {
    public static void main(String[] args) {
        int[] result =new int[10];

        String s = Arrays.toString(result);
        System.out.println(s);
        String[] split = s.split(",");

        for (String ss:split){
            System.out.println(ss);
        }
    }
    public int[] beautifulArray(int N) {
        int[] result =new int[N];

        String s = Arrays.toString(result);
        System.out.println(s);
        return result;
    }
}
