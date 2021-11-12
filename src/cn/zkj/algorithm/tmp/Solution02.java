package cn.zkj.algorithm.tmp;

import cn.zkj.algorithm.construct.TreeNode;

import java.util.Stack;

/**
 * 230. 二叉搜索树中第K小的元素
 * @Author: zhaoKaiJie
 * @Description:
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @Date: 2021/10/17
 * @version: 01
 */
public class Solution02 {

    public int kthSmallest(TreeNode root, int k) {
        int x=1;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.empty()){
            TreeNode pop = stack.pop();
            if (pop==null){
                continue;
            }
            if (pop.left!=null)


        }


    }
}
