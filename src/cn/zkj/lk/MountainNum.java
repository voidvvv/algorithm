package cn.zkj.lk;

/*.com/problems/find-peak-element
* 峰值元素是指其值大于左右相邻值的元素。

给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。

数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。

你可以假设 nums[-1] = nums[n] = -∞。

示例 1:

输入: nums = [1,2,3,1]
输出: 2
解释: 3 是峰值元素，你的函数应该返回其索引 2。
示例 2:

输入: nums = [1,2,1,3,5,6,4]
输出: 1 或 5
解释: 你的函数可以返回索引 1，其峰值元素为 2；
     或者返回索引 5， 其峰值元素为 6。
说明:

你的解法应该是 O(logN) 时间复杂度的。

来源：力扣（LeetCode）
链接：https://leetcode-cn
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

import javax.sql.rowset.serial.SerialArray;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class MountainNum {
    public static void main(String[] args) {
       MountainNum m=new MountainNum();

       long s=m.summ(8);

        System.out.println(s);

    }

    public int findPeakElement(int[] nums) {
        int m =0;

        return m;

    }

    public int dg(int i){
        if (i<=2){
            return 1;
        }

        return dg(i-1)+dg(i-2);
    }

    public int summ(int i){
        int sum=0;
        for (int x=1;x<=i;x++){
            sum+=dg(x);
        }

        return sum;
    }
}
