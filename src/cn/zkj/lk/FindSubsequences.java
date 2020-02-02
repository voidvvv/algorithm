package cn.zkj.lk;

import java.util.ArrayList;
import java.util.List;

/*

给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/increasing-subsequences
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        int start=0;
        int end =1;

        List<List<Integer>> re =new ArrayList<>();

        while (end<nums.length){
            while (end<nums.length&&nums[end-1]<nums[end]){
                List<Integer> temp = new ArrayList<>();

                for (int x=start;x<=end;x++){
                    temp.add(nums[x]);
                }
                re.add(temp);
                end++;
            }
            start=end;

        }
        return  re;
    }

}
