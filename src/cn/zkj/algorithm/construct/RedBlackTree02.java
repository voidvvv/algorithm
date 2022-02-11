package cn.zkj.algorithm.construct;

/**
 * Author: KJ.ZHAO
 * Date: 2022/2/11 11:39
 */
public class RedBlackTree02 <T extends Comparable>{
    private Node root;
    private class Node{
        boolean red;
        Node parent;
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.data = data;
            this.red = true; // 新节点默认红色
        }

        public boolean isLeft(){
            return this.parent!=null && parent.left==this;
        }
        public boolean isRight(){
            return this.parent!=null && parent.right==this;
        }
        public boolean isRoot(){
            return this.parent == null;
        }
    }

    private Node parentOf(Node node){
        return node==null?null:node.parent;
    }

    private Node leftOf(Node node){
        return node==null?null:node.left;
    }

    private Node rightOf(Node node){
        return node==null?null:node.right;
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
        return node!=null&&node.red;
    }

    private void rotateLeft(Node node){
        if (node==null||node.right==null){
            return;
        }
        Node p = node.parent;
        Node r = node.right;
        Node rl = r.left;

        if (p!=null){
            if (node.isLeft()){
                p.left = r;
            }else {
                p.right = r;
            }
        }
        r.left = node;
        r.parent = p;

        node.parent = r;
        node.right = rl;
    }

    private void  rotateRight(Node node){
        if (node==null||node.left==null){
            return;
        }
        Node p =node.parent;
        Node l = node.left;
        Node lr = l.right;

        if (p!=null){
            if (node.isLeft()){
                p.left = l;
            }else {
                p.right = l;
            }
        }
        l.parent = p;

        node.parent = l;
        node.left = lr;

        l.right = node;
    }

    public void add(T data){
        if (this.root==null){
            this.root = new Node(data);
            this.root.red = false;
            return;
        }

        Node target = root;
        Node p = null;
        while (target!=null){
            p = target;
            if (data.compareTo(target.data)>0){
                target = target.right;
            }else if (data.compareTo(target.data)<0){
                target = target.left;
            }else {
                // 已经放过
                target.data = data;
                return;
            }
        }
        Node newNode = new Node(data);
        newNode.parent = p;
        if (data.compareTo(p.data)>0){
            p.right = newNode;
        }else {
            p.left = newNode;
        }

        fixAfterInsert(newNode);
    }

    /**
     * 添加后修复红黑树
     * @param x
     */
    private void fixAfterInsert(Node x) {
        if (x==null){
            return;
        }
        x.red = true;
        while (x!=null && parentOf(x)!=null && redOf(parentOf(x))){
            if (parentOf(x).isLeft()){
                Node uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (x.isRight()){
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
                }else {
                    if (x.isLeft()){
                        x= parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateLeft(grandParentOf(x));
                }
            }
        }

        while (parentOf(this.root)!=null){
            root = parentOf(this.root);
        }
        this.root.red = false;
    }


    public void remove(T data){
        if (this.root==null || data==null){
            return;
        }

        Node target = getTarget(data);
        if (target==null){
            return;
        }
        if (target.left!=null && target.right!=null){
            Node succeed = target.left;
            while (succeed.right!=null){
                succeed = succeed.right;
            }

            target.data = succeed.data;
            target = succeed;
        }
        Node replacement = target.left==null?target.right:target.left;
        if (replacement!=null){
            replacement.parent = target.parent;
            if (target==this.root){
                this.root = replacement;
                this.root.parent = null;
                this.root.red = false;
            }else if (target.isLeft()){
                target.parent.left = replacement;

            }else if (target.isRight()){
                target.parent.right = replacement;
            }

            target.left = target.right = target.parent = null;
            if (!redOf(target)){
                // 删掉了个黑节点
                fixAfterDelete(replacement);
            }
        }else if (target==this.root){
            this.root =null;
        }else {
            if (!redOf(target)){
                fixAfterDelete(target);
            }
            if (target.isLeft()){
                target.parent.left = null;
            }else {
                target.parent.right = null;
            }
            target.left = target.right = target.parent = null;
        }
    }

    /**
     * 删除后修复红黑树
     * @param x
     */
    private void fixAfterDelete(Node x) {
        while (x!=null && x!=root && !redOf(x)){
            if (x.isLeft()){
                Node s = rightOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(s),true);
                    rotateLeft(parentOf(x));
                    s = rightOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(rightOf(s))){
                        // 因为兄弟节点作为右节点，并且是黑色，需要被左旋成为当前父节点的父节点。那么它的右节点会跟上去，在左旋的时候会将s和parentOf(s)变色，
                        // 这个右节点的高度由p->black->current 变成了 p -> current
                        // 少了个黑节点高度的。所以需要保证右节点为红，在左旋上去后将其变黑保证黑高
                        setColor(s,true);
                        setColor(leftOf(s),false);
                        rotateRight(s);
                        s = rightOf(parentOf(x));
                    }
                    setColor(s,colorOf(parentOf(x)));
                    setColor(parentOf(x),false);
                    setColor(rightOf(s),false);
                    rotateLeft(parentOf(x));
                }
            }else { // symmetric
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
                        setColor(s,true);
                        setColor(rightOf(s),false);
                        rotateLeft(s);
                        s = leftOf(parentOf(x));
                    }
                    setColor(s,parentOf(s).red);
                    setColor(parentOf(s),false);
                    setColor(leftOf(s),false);
                    rotateRight(parentOf(s));
                }
            }
        }
        setColor(x,false);
        setColor(this.root,false);
    }

    private boolean colorOf(Node x) {
        return x!=null && x.red;
    }

    private Node getTarget(T data) {
        Node re = this.root;
        while (re!=null){
            if (data.compareTo(re.data)>0){
                re = re.right;
            }else if (data.compareTo(re.data)<0){
                re = re.left;
            }else {
                return re;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RedBlackTree02<Integer> tree = new RedBlackTree02<Integer>();
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
