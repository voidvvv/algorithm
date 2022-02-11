package cn.zkj.algorithm.construct;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/9 14:38
 */
public class RedBlackTree<T extends Comparable> {
    private Node root;

    private class Node {
        boolean red;
        Node parent;
        Node left;
        Node right;
        T data;

        public Node() {
        }

        public Node(T data) {
            this.data = data;
            this.red = true;
        }

        public boolean isLeftNode() {
            return this.parent != null && this.parent.left == this;
        }

        public boolean isRightNode() {
            return this.parent != null && this.parent.right == this;
        }
    }

    private Node parentOf(Node node) {
        return node == null ? null : node.parent;
    }

    private Node grandParentOf(Node node){
        return parentOf(parentOf(node));
    }

    private Node leftOf(Node node) {
        return node == null ? null : node.left;
    }

    private Node rightOf(Node node) {
        return node == null ? null : node.right;
    }

    private void setColor(Node node, boolean red) {
        if (node != null) {
            node.red = red;
        }
    }

    private boolean redOf(Node node) {
        return node != null && node.red;
    }

    /**
     * 左旋
     *
     * @param node
     */
    private void rotateLeft(Node node) {
        if (node == null || node.right == null) {
            return;
        }
        Node r = node.right;
        Node p = node.parent;
        Node rl = r.left;

        node.right = rl;
        if (rl != null) {
            rl.parent = node;
        }

        r.left = node;

        if (p != null) {
            if (node.isLeftNode()) {
                p.left = r;
            } else {
                p.right = r;
            }
        }
        node.parent = r;
        r.parent = p;
    }

    /**
     * 右旋
     *
     * @param node
     */
    private void rotateRight(Node node) {
        if (node == null || node.left == null) {
            return;
        }

        Node l = node.left;

        Node lr = l.right;

        Node p = node.parent;


        l.right = node;

        node.left = lr;

        l.parent = p;

        if (p != null) {
            if (node.isLeftNode()) {
                p.left = l;
            } else {
                p.right = l;
            }
        }
        node.parent = l;
    }

    public boolean add(T data){
        if (data==null){
            return false;
        }
        if (root==null){
            root = new Node(data);
            root.red = false;
            return true;
        }
        Node p = null;
        Node c = root;
        while (c!=null){
            p = c;
            if (data.compareTo(c.data)>0){
                c = c.right;
            }else if (data.compareTo(c.data)<0){
                c = c.left;
            }else {
                c.data = data;
                return true;
            }

        }
        Node x = new Node(data);
        if (data.compareTo(p.data)>0){
            p.right = x;
        }else {
            p.left = x;
        }
        x.parent = p;

        fixAfterInsert(x);
        return true;
    }

    /**
     * 插入后修复红黑树
     * @param x
     */
    private void fixAfterInsert(Node x) {
        x.red = true; // 新插入的需要是红节点
        while (x!=null && x!=root&& x.parent!=null && x.parent.red){
            if (parentOf(x).isLeftNode()){
                Node uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    parentOf(x).red = false;
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (x.isRightNode()){
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateRight(grandParentOf(x));
                }
            }else { // symmetry
                Node uncle = leftOf(grandParentOf(x));
                if (redOf(uncle)){
                    parentOf(x).red = false;
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (x.isLeftNode()){
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    parentOf(x).red = false;
                    setColor(grandParentOf(x),true);
                    rotateLeft(grandParentOf(x));
                }
            }
        }
        while (this.root.parent!=null){
            this.root = this.root.parent;
        }
        root.red = false;
    }

    public void remove(T data){
        if (root==null|| data==null){
            return;
        }
        Node c = root;
        while (c!=null && !(c.data==data || c.data.equals(data))){
            if (c.data.compareTo(data)>0){
                c = c.left;
            }else {
                c = c.right;
            }
        }
        if (c==null){
            return; // 没有该节点
        }
        if (c.left!=null && c.right!=null){
            Node n=c.left;
            while (n.right!=null){
                n = n.right;
            }
            c.data = n.data;
            c= n;
        }
        Node succeed = c.left==null?c.right:c.left;

        if (succeed!=null){
            Node p = c.parent;
            if (c.isRightNode()){
                p.right = succeed;
            }else {
                p.left = succeed;
            }
            succeed.parent = p;
            if (!c.red){
                fixAfterDelete(succeed);
            }
        }else if (this.root==c){
            this.root = null;
        }else {
            Node p = c.parent;
            if (!c.red){
                fixAfterDelete(c);
            }
            if (c.isRightNode()){
                p.left = null;
            }else {
                p.right = null;
            }
            c= null; // help GC
        }
    }

    /**
     * 删除后恢复红黑树
     * @param x
     */
    private void fixAfterDelete(Node x) {
        while (x!=null && !x.red && x!=root){
            if (x.isLeftNode()){
                Node s = rightOf(parentOf(x));
                if (s.red){
                    s.red = false;
                    parentOf(x).red = true;
                    rotateLeft(parentOf(x));
                    s = rightOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) && !redOf(leftOf(s))){
                    setColor(s,true);
                    x=  parentOf(x);
                }else {
                    if (!redOf(s.right)){
                        s.left.red = false;
                        s.red = true;
                        rotateRight(s);
                        s = rightOf(parentOf(x));
                    }
                    s.red = parentOf(x).red;
                    parentOf(x).red = false;
                    setColor(s.right,false);
                    rotateLeft(parentOf(x));
                }
            }else { // symmetric
                Node s=  leftOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(s),true);
                    rotateRight(parentOf(s));
                }
                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = x.parent;
                }else {
                    if (!redOf(leftOf(s))){
                        setColor(rightOf(s),false);
                        setColor(s,true);
//                        setColor(parentOf(s),false);
                        rotateLeft(s);
                        s = leftOf(parentOf(x));
                    }
                    setColor(s,parentOf(s).red);
                    setColor(leftOf(s),false);
                    setColor(parentOf(s),false);
                    rotateRight(parentOf(s));
                }
            }
        }
        setColor(x,false);
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> tree = new RedBlackTree<Integer>();
        int[] arr  = new int[]{1,2,3,4,9,0,-2,63,-20};
        for (int x=0;x<arr.length;x++){
            tree.add(arr[x]);
        }
        System.out.println("========================");
        for (int x=0;x<arr.length;x++){
            tree.remove(arr[x]);
        }
        System.out.println("end");
    }
}
