package cn.zkj.algorithm.construct.listnode;

/**
 * @Classname Node
 * @Description
 * @Date 2022/2/21 21:53
 * @Created by zkj
 */
public class Node <T extends Comparable<T>>{
    public boolean red;
    public Node<T> left;
    public Node<T> right;
    public Node<T> parent;
    public T data;

    public Node(T data) {
        this.data = data;
        this.red = true;
    }

    public static <R extends Comparable<R>> Node<R> leftOf(Node<R> node){
        return null;
    }
}
