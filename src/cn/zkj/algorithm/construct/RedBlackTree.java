package cn.zkj.algorithm.construct;

/**
 * 红黑树
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/1/31
 * @version: 01
 */
public class RedBlackTree<T extends Comparable> {
    private Node root;

    public boolean add(T data){
        if (root==null){
            root = new Node(null,null,null,false,data);
        }else {
            Node parent = null;
            Node now = root;
            int c= 0;
            while (now!=null){
                parent = now;
                c = parent.data.compareTo(data);

                if (c>0){
                    now = parent.left;
                }else if (c<0){
                    now = parent.right;
                }else {
                    break;
                }
            }
            Node x = new Node(parent,null,null,false,data);
            if (c>0){
                parent.left = x;
            }else if (c<0){
                parent.right = x;
            }else {
                return false;
            }
            fixTreeAfterInsert(x);

        }
        return true;

    }

    private void fixTreeAfterInsert(Node x) {
        x.red = true;

        while (x!=null &&x!=root&& x.parent!=null && x.parent.red){ // 若父节点为黑色，则这里直接插入红节点即可，不需要调整

            if (parentOf(x).isLeft()){
                Node uncle= rightOf(grandfatherOf(x));
                if (redOf(uncle)){
                    setColor(x.parent,false);
                    setColor(uncle,false);
                    setColor(grandfatherOf(x),true);
                    x = grandfatherOf(x);
                }else {
                    if (x.isRight()){
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandfatherOf(x),true);
                    rotateRight(grandfatherOf(x));
                }

            }else {
                Node uncle= leftOf(grandfatherOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandfatherOf(x),true);
                    x = grandfatherOf(x);
                }else {
                    if (x.isLeft()){
                        x= parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandfatherOf(x),true);
                    rotateLeft(grandfatherOf(x));
                }
            }
        }


        // 根节点永远为黑
        root.red = false;
    }

    private Node parentOf(Node p) {
        return p == null ? null : p.parent;
    }

    private Node grandfatherOf(Node p) {
        return parentOf(parentOf(p));
    }

    private Node leftOf(Node p) {
        return p == null ? null : p.left;
    }

    private Node rightOf(Node p) {
        return p == null ? null : p.right;
    }

    private boolean redOf(Node p) {
        return p != null && p.red;
    }

    private void setColor(Node p, boolean red) {
        if (p != null) {
            p.red = red;
        }
    }

    /**
     * 左旋
     * @param p
     */
    private void rotateLeft(Node p){
        if (p==null||p.right==null){
            return;
        }
        Node r = p.right;
        Node l = r.left;
        Node parent = p.parent;

        r.left = p;
        if (parent==null){
            this.root = r;
        }else if (p==parent.left){
            parent.left = r;
        }else {
            parent.right = r;
        }

        r.parent = parent;
        p.parent = r;
        p.right = l;



    }

    private void rotateRight(Node p){
        if (p==null || p.left==null){
            return;
        }
        Node parent = p.parent;
        Node nh = p.left;
        Node tr = nh.right;

        p.left = tr;
        nh.right = p;
        nh.parent = parent;
        if (parent==null){
            this.root = nh;
        }else if (p == parent.left){
            parent.left = nh;
        }else {
            parent.right = nh;
        }
        p.parent = nh;
    }

    private  class Node  {
        private Node parent;
        private Node left;
        private Node right;
        private boolean red;
        private T data;

        public Node(T data) {
            this(null,null,null,false,data);
        }

        public Node(Node parent, Node left, Node right, boolean red, T data) {
            this.parent = parent;
            this.left = left;
            this.right = right;
            this.red = red;
            this.data = data;
        }

        public boolean isRoot(){
            return this.parent==null;
        }

        public boolean isLeft(){
            return this.parent != null && this == this.parent.left;
        }

        public boolean isRight(){
            return this.parent != null && this == this.parent.right;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj.getClass() == Node.class) {
                Node target = (Node) obj;
                return data.equals(target.data) && left == target.left && right == target.right && parent == target.parent && red == target.red;
            }
            return false;

        }
    }

    public static void main(String[] args) {
        RedBlackTree<Integer> myTree = new RedBlackTree<>();

        myTree.add(5);
        myTree.add(4);
        myTree.add(3);
        myTree.add(10);
        System.out.println(myTree);
    }

}
