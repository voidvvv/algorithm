package cn.zkj.lk;

import java.util.ArrayList;
import java.util.List;

/*
给定一个非空二叉树, 返回一个由每层节点平均值组成的数组.

示例 1:

输入:
    3
   / \
  9  20
    /  \
   15   7
输出: [3, 14.5, 11]
解释:
第0层的平均值是 3,  第1层是 14.5, 第2层是 11. 因此返回 [3, 14.5, 11].
注意：

节点值的范围在32位有符号整数范围内。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/average-of-levels-in-binary-tree
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AverageOfLevels {
    public static void main(String[] args) {
        AverageOfLevels a =new AverageOfLevels();
        int demo = a.demo(9, 34);

        System.out.println(demo);
    }

    public int demo(int a,int b){
        try{
            return a+b;
        }catch (Exception e){
            System.out.println("catch");
        }finally {
            System.out.println("fina");
        }
        return 0;
    }
}
