package cn.zkj.algorithm.construct;

import cn.zkj.algorithm.construct.listnode.Node;
import cn.zkj.algorithm.construct.listnode.TreeNodeUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname TreeUtil
 * @Description
 * @Date 2022/2/21 21:54
 * @Created by zkj
 */
public class TreeUtil {

    public static void main(String[] args) {
        RedBlackTree17<Integer> tree = new RedBlackTree17<Integer>();
        int[] arr  = new int[]{1,2,3,4,9,0,-2,63,-20};
        for (int x=0;x<arr.length;x++){
            int t = arr[x];
            tree.add(arr[x]);
        }
        System.out.println("========================");
        TreeNodeUtils.traverse(tree.root);
        System.out.println("========================");
        for (int x=0;x<arr.length;x++){

            tree.del(arr[x]);
            System.out.println("===del:"+arr[x]+"===");
            TreeNodeUtils.traverse(tree.root);
            System.out.println("======");
        }

        System.out.println("end");
    }


    static public void traverse(Node root){
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue.offer(root);
        int x=1;

        while (true){
            boolean f = true;
            StringBuilder print = new StringBuilder(String.format("第%s层",x++));
            if (!queue.isEmpty()){
                while (!queue.isEmpty()){
                    Node poll = queue.poll();
                    if (poll==null){
                        print.append("null\t");
                    }else {
                        f= false;
                        print.append(poll.data);
                        print.append(" ");
                        print.append(poll.red).append("\t");
                        queue2.offer(poll.left);
                        queue2.offer(poll.right);
                    }
                }
            }else if (!queue2.isEmpty()){
                while (!queue2.isEmpty()){
                    Node poll = queue2.poll();
                    if (poll==null){
                        print.append("null\t");
                    }else {
                        f= false;
                        print.append(poll.data);
                        print.append(" ");
                        print.append(poll.red).append("\t");
                        queue.offer(poll.left);
                        queue.offer(poll.right);
                    }
                }
            }

            System.out.println(print.toString());
        }

    }
}
