package cn.zkj.algorithm.construct.listnode;

/**
 * @Classname Node
 * @Description
 * @Date 2022/2/21 21:53
 * @Created by zkj
 */
public class Node <T extends Comparable<T>>{
    public boolean red;
    public Node left;
    public Node right;
    public Node parent;
    public T data;

    public Node(T data) {
        this.data = data;
        this.red = true;
    }
}
