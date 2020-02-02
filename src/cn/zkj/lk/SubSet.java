package cn.zkj.lk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//78. 子集
/*

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: nums = [1,2,3]
输出:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

这个题蛮有意思的，可以直接从后遍历，遇到一个数就把所有子集加上该数组成新的子集，遍历完毕即是所有子集

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/subsets
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SubSet {
    public static void main(String[] args) {
        /*List<SubSet> list =new ArrayList<>();
        list.add(new SubSet());
        list.add(new SubSet());
        System.out.println(list);
        list.remove(1);
        System.out.println(list);*/

        boolean b = "aaaa".contentEquals(new StringBuilder("aaaa"));
        boolean asd = "aaa".equals(new StringBuilder("aaa"));
        System.out.println(asd);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> first=new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        result.add(first);
        for (int i:nums){
            int size =result.size();
            for (int x=0;x<size;x++){
                List<Integer> temp =new ArrayList<>(result.get(x));
                temp.add(i);
                result.add(temp);
            }
        }
        return result;
    }
}
