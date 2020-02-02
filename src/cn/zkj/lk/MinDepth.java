package cn.zkj.lk;


import java.util.ArrayList;
import java.util.List;

public class MinDepth {
    public int minDepth(TreeNode root) {

        if (root==null){
            return 0;
        }


        int n=1;
        List<TreeNode> list =new ArrayList<>();
        list.add(root);

        return circle(list,n);

    }

    public int circle(List<TreeNode> list,int i){
        List<TreeNode> list1 =new ArrayList<>();
        for (TreeNode treeNode:list){
            if (treeNode.left==null&&treeNode.right==null){
                return i;
            }
            if(treeNode.left!=null){
                list1.add(treeNode.left);
            }
            if (treeNode.right!=null){
                list1.add(treeNode.right);
            }

        }

        return circle(list1,i+1);

    }


}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }