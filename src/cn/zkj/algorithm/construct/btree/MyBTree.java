package cn.zkj.algorithm.construct.btree;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @Classname MyBTree
 * @Description
 * @Date 2022/6/12 0:00
 * @Created by zkj
 */
public class MyBTree <T extends Comparable<T>>{
    Node root;
    int n; // 阶数

    class Node{
        T[] range;
        boolean leafSign;
        Node parent;
        List<Node> children;
        Node next;

        public Node(T data,int n) {
            range = (T[]) Array.newInstance(Comparable.class,n);
            range[0] = data;
        }
    }

    public static void main(String[] args) {
//        Comparable c = (Comparable) new Object();

    }

}
