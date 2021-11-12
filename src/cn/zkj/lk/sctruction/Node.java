package cn.zkj.lk.sctruction;

import java.util.List;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2021/6/19
 * @version: 01
 */
public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
    public Node random;
//    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
