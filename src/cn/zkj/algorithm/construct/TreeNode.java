package cn.zkj.algorithm.construct;

/**
 * @Author: zhaoKaiJie
 * @Description: 二叉树
 * @Date: 2021/3/28
 * @version: 01
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {
    }
}
