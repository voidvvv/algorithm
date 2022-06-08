package cn.zkj.algorithm;

import cn.zkj.algorithm.construct.TreeNode;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Classname AlSolution
 * @Description
 * @Date 2022/4/26 9:16
 * @Created by zkj
 */
public class AlSolution {
    // 层级遍历
    public static void levelTraver(TreeNode root){
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        int level = 1;
        while (!queue.isEmpty()){
            System.out.print("第"+(level++)+"层：\t");
            int size = queue.size();
            for(int x=0;x<size;x++){
                TreeNode poll = queue.poll();
                System.out.print(poll.val+"\t");
                if (poll.left!=null){
                    queue.offer(poll.left);
                }
                if (poll.right!=null){
                    queue.offer(poll.right);
                }
            }
            System.out.println();
        }
    }

    // 非递归正序遍历
    public List<TreeNode> preOrderTraverse(TreeNode root){
        System.out.println(" 前序遍历二叉树：");
        List<TreeNode> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            ans.add(pop);
            System.out.print(pop.val+"\t");
            if (pop.right!=null){
                stack.push(pop.right);
            }
            if (pop.left!=null){
                stack.push(pop.left);
            }
        }
        return ans;
    }

    // 中序遍历
    public List<TreeNode> midOrderTraverse(TreeNode root){
        System.out.println(" 中序遍历： ");
        Stack<TreeNode> stack = new Stack<>();
        List<TreeNode> ans = new ArrayList<>();
        TreeNode cur = root;
        TreeNode forbid = null;
        while (cur!=null){
            while (cur.left!=null && forbid!=cur.left){
                stack.push(cur);
                cur = cur.left;
            }
            System.out.print(cur.val+"\t");
            ans.add(cur);
            if (cur.right!=null){
                cur = cur.right;
            }else if (stack.isEmpty()){
                break;
            }else {
                cur = stack.pop();
                forbid = cur.left;
            }
        }
        return ans;
    }

    // 后序遍历
    public List<TreeNode> afterOderTraverse(TreeNode root){
        Set<TreeNode> visit = new HashSet<>();

        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        stack.clear();
        while (!stack.isEmpty()){
            TreeNode peek = stack.peek();
            boolean terminal = true;
            if (peek.right!=null && !visit.contains(peek.right)){
                terminal =false;
                stack.push(peek.right);
            }
            if (peek.left!=null && !visit.contains(peek.left)){
                terminal =false;
                stack.push(peek.left);
            }

            if (terminal){
                visit.add(peek);
                System.out.print(peek.val+"\t");
                stack.pop();
            }
        }
        System.out.println();
        return null;
    }

    public static void main(String[] args) {
        AlSolution a1 = new AlSolution();
        TreeNode treeNode = generateRandomTreeNode(4,true,30);

        levelTraver(treeNode);
        System.out.println("=============");
        a1.preOrderTraverse(treeNode);
        System.out.println("=============");
        a1.midOrderTraverse(treeNode);
        System.out.println("=============");
        a1.afterOderTraverse(treeNode);

    }

    public static TreeNode generateRandomTreeNode(int level,boolean full,int valBound){
        if (level == 0){
            return null;
        }
        TreeNode root = new TreeNode();
        root.val = ThreadLocalRandom.current().nextInt(valBound);
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        for (int x=1;x<level;x++){
            if (!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i< size; i++){
                    TreeNode pop = queue.poll();
                    if (full || ThreadLocalRandom.current().nextInt(2)==0){
                        TreeNode left = new TreeNode();
                        left.val = ThreadLocalRandom.current().nextInt(valBound);
                        pop.left = left;
                        queue.offer(left);
                    }

                    if (full || ThreadLocalRandom.current().nextInt(2)==0){
                        TreeNode right = new TreeNode();
                        right.val = ThreadLocalRandom.current().nextInt(valBound);
                        pop.right = right;
                        queue.offer(right);
                    }
                }
            }
        }
        return root;
    }
}
