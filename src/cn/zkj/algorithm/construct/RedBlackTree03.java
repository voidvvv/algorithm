package cn.zkj.algorithm.construct;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/2/11
 * @version: 01
 */
public class RedBlackTree03 <T extends Comparable<T>>{
    private Node root;
    class Node{
        private boolean red;
        private Node left;
        private Node right;
        private Node parent;
        private T data;
        
        public Node(T data){
            this.data = data;
            this.red = true;
        }
        
    }
    
    private void rotateLeft(Node node){
        if (node == null || node.right == null){
            return;
        }
        
        Node r = node.right;
        Node p = node.parent;
        Node rl = r.left;
        r.parent = p;
        if (p!=null){
            if (isLeft(node)){
                p.left = r;
            }else {
                p.right = r;
            };
        }
        
        r.left = node;
        node.parent = r;
        node.right =  rl;
    }
    
    private void rotateRight(Node node){
        if (node == null || node.left == null){
            return;
        }
        Node l = node.left;
        Node lr = l.right;
        Node p = node.parent;
        
        if (p!=null){
            if (isLeft(node)){
                p.left = l;
            }else {
                p.right = l;
            }
        }
        
        l.parent = p;
        l.right =node;
        
        node.parent = l;
        node.left = lr;
    }

    private boolean isLeft(Node node) {
        return leftOf(parentOf(node)) == node;
    }

    private Node leftOf(Node node) {
        return node==null?null:node.left;
    }

    private Node rightOf(Node node) {
        return node==null?null:node.right;
    }

    private Node parentOf(Node node) {
        return node==null?null:node.parent;
    }
    
    private Node grandParentOf(Node node){
        return parentOf(parentOf(node));
    }
    
    private boolean redOf(Node node){
        return node!=null && node.red;
    }
    
    private boolean isRoot(Node node){
        return node!=null && node.parent==null;
    }
    
    private void setColor(Node node,boolean red){
        if (node!=null){
            node.red = red;
        }
    }
    
    public void add(T data){
        if (data==null){
            return;
        }
        if (root==null){
            root = new Node(data);
            root.red = false;
            return;
        }
        
        Node p = null;
        Node c = root;
        
        while (c!=null){
            p = c;
            int i = data.compareTo(c.data);
            if (i>0){
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
        while (x!=null && !isRoot(x) && redOf(x) && redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                Node uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (!isLeft(x)){
                        x= parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateRight(grandParentOf(x));
                }
            }else { // symmetric
                Node uncle = leftOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else{
                    if (isLeft(x)){
                        x= parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateLeft(grandParentOf(x));
                }
            }
        }

        while (this.root.parent!=null){
            this.root = parentOf(this.root);
        }
        setColor(root,false);
    }

    public void remove(T data){
        if (data==null || root==null){
            return;
        }
        Node target = getTarget(data);
        if (target!=null){
            // 寻找左子树最大的结点
            if (leftOf(target)!=null && rightOf(target)!=null){
                Node t = target.left;
                while (rightOf(t)!=null){
                    t = rightOf(t);
                }
                target.data = t.data;
                target = t;
            }
            Node succeed = target.left==null?target.right:target.left;
            if (succeed!=null){
                Node p = target.parent;
                if (isLeft(target)){
                    p.left = succeed;
                }else {
                    p.right = succeed;
                }
                succeed.parent = p;

                target.left = target.right = target.parent = null;
                if (!redOf(target)){
                    // 移除一个黑元素，需要调整树
                    fixAfterDelete(succeed);
                }
            }else if (this.root==target){
                this.root = null;
            }else {
                if (!redOf(target)){
                    fixAfterDelete(target);
                }
                Node p = parentOf(target);
                if (isLeft(target)){
                    p.left = null;
                }else {
                    p.right = null;
                }
                target.left = target.right = target.parent = null;
            }
        }
    }

    private void fixAfterDelete(Node x) {
        while (x!=null && !redOf(x)){
            if (isLeft(x)){
                Node s = rightOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(s),true);
                    rotateLeft(parentOf(s));
                    s= rightOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(rightOf(s))){
                        setColor(s,true);
                        setColor(leftOf(s),false);
                        rotateRight(s);
                        s = rightOf(parentOf(x));
                    }
                    setColor(s,parentOf(s).red);
                    setColor(parentOf(s),false);
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
                if (!redOf(leftOf(s)) && !redOf(rightOf(x))){
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
    }

    private Node getTarget(T data) {
        Node res = root;
        while (res!=null){
            int i = data.compareTo(res.data);
            if (i >0){
                res = res.right;
            }else if (i<0){
                res = res.left;
            }else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        RedBlackTree03<Integer> tree = new RedBlackTree03<Integer>();
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
