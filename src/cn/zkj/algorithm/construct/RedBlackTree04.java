package cn.zkj.algorithm.construct;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/2/12
 * @version: 01
 */
public class RedBlackTree04 <T extends Comparable<T>>{
    private Node root;

    class Node{
        boolean red;
        Node parent;
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
            this.red = true;
        }
    }

    private Node leftOf(Node node){
        return node==null?null:node.left;
    }

    private Node rightOf(Node node){
        return node==null?null:node.right;
    }

    private Node parentOf(Node node){
        return node==null?null:node.parent;
    }
    private Node grandParentOf(Node node){
        return parentOf(parentOf(node));
    }

    private void setColor(Node node,boolean red){
        if (node!=null){
            node.red = red;
        }
    }

    private boolean redOf(Node node){
        return node!=null && node.red;
    }

    private boolean isRoot(Node node){
        return parentOf(node) == null;
    }

    private boolean isLeft(Node node){
        return leftOf(parentOf(node)) == node;
    }

    private boolean isRight(Node node){
        return rightOf(parentOf(node)) == node;
    }

    private void rotateLeft(Node node){
        if (node==null || node.right==null){
            return;
        }
        Node r = node.right;
        Node rl = r.right;
        Node p = node.parent;

        if (p!=null){
            if (isLeft(p)){
                p.left = r;
            }else {
                p.right = r;
            }
        }

        r.parent = p;
        r.left = node;
        node.parent = r;
        node.right = rl;
    }

    private void  rotateRight(Node node){
        if (node==null || node.left==null){
            return;
        }
        Node l = leftOf(node);
        Node p = parentOf(node);
        Node lr = rightOf(l);

        if (p!=null){
            if (isLeft(node)){
                p.left = l;
            }else {
                p.right = l;
            }
        }

        l.parent = p;
        l.right = node;
        node.parent = l;
        node.left = lr;
    }

    public void add(T data){
        if (data==null){
            return;
        }
        if (this.root == null){
            this.root = new Node(data);
            this.root.red = false;
            return;
        }

        Node p = null;
        Node c = root;

        while (c!=null){
            p = c;
            int i = data.compareTo(c.data);
            if (i >0){
                c = c.right;
            }else if (i<0){
                c = c.left;
            }else {
                c.data = data;
                return;
            }
        }
        int i = data.compareTo(p.data);
        Node x = new Node(data);
        x.parent = p;
        if (i>0){
            p.right = x;
        }else {
            p.left = x;
        }
        fixAfterInsert(x);
    }

    private void fixAfterInsert(Node x) {
        while (x!=null &&  redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                Node uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (isRight(x)){
                        x= parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateRight(grandParentOf(x));
                }
            }else {
                Node uncle = leftOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else{
                    if (isLeft(x)){
                        x=parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateLeft(grandParentOf(x));
                }

            }
        }

        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
        this.root.red = false;
    }

    public void remove(T data){
        if (data==null){
            return;
        }

        Node t = getTarget(data);
        if (t!=null){

            if (leftOf(t)!=null && rightOf(t)!=null){ // 左右子树都存在
                // 寻找左子树最大的节点作为代替节点
                Node suc = t.left;
                while (rightOf(suc)!=null){
                    suc = rightOf(suc);
                }

                t.data = suc.data;
                t = suc;
            }

            Node next = leftOf(t)==null?leftOf(t):rightOf(t); // 待删除节点的替代节点
            if (next!=null){
                // 不为空，代表其应该还有一个子树,next就是子树的父节点，来代替当前结点
                if (isRoot(t)){ // 若待删除结点为根节点
                    this.root = next;
                    this.root.parent = null;
                    t.left = t.right = t.parent = null;
                }else {
                    Node p = parentOf(t);
                    if (isLeft(t)){
                        p.left = next;
                    }else {
                        p.right = next;
                    }
                    next.parent = p;
                    t.left = t.right = t.parent = null;
                    if (!redOf(t)){
                        fixAfterDelete(next);
                    }
                }

            }else if (isRoot(t)){ // 无后继结点，当前节点处变为空
                // 若需要变空的是根节点，则直接移除
                this.root = null;
            }else {
                // 不是根节点，需要判断是否需要修复红黑树
                if (!redOf(t)){
                    fixAfterDelete(t);
                }
                Node p = parentOf(t);
                if (isLeft(t)){
                    p.left = null;
                }else {
                    p.right = null;
                }
                t = null;
            }
        }
    }

    /**
     * x，调整红黑树来修复该缺少的黑结点
     * @param x
     */
    private void fixAfterDelete(Node x) {
        while (x!=null && !redOf(x)){
            if (isLeft(x)){
                Node s = rightOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(x),true);
                    rotateLeft(parentOf(x));
                    s = rightOf(parentOf(x));
                }
                if (!redOf(leftOf(s))&& !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(rightOf(s))){
                        setColor(s,true);
                        setColor(leftOf(s),false);
                        rotateRight(s);
                        s = rightOf(parentOf(x));
                    }
                    setColor(s,parentOf(x).red);
                    setColor(parentOf(x),false);
                    setColor(rightOf(s),false);
                    rotateLeft(parentOf(s));
                }
            }else {
                Node s = leftOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(s),true);
                    rotateRight(parentOf(s));
                    s = leftOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(leftOf(s))){
                        setColor(rightOf(s),false);
                        setColor(s,true);
                        rotateRight(s);
                        s = leftOf(parentOf(x));
                    }
                    setColor(s,parentOf(x).red);
                    setColor(parentOf(x),false);
                    setColor(leftOf(s),false);
                    rotateRight(parentOf(s));
                }
            }
        }

        setColor(x,false);
//        setColor(this.root,false);
    }

    private Node getTarget(T data) {
        Node t = this.root;
        while (t!=null){
            int i = data.compareTo(t.data);
            if (i >0){
                t = t.right;
            }else if(i <0){
                t = t.left;
            }else {
                return t;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        RedBlackTree04<Integer> tree = new RedBlackTree04<Integer>();
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
