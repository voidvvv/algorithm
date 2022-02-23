package cn.zkj.algorithm.construct;

/**
 * @Classname RedBlackTree12
 * @Description 2022年2月23日23:23:39  2022年2月23日23:50:14
 * @Date 2022/2/23 23:22
 * @Created by zkj
 */
public class RedBlackTree12 <T extends Comparable<T>>{
    private Node root;
    class Node{
        boolean red;
        Node parent;
        Node left;
        Node right;
        T data;

        public Node(T data) {
            this.red = true;
            this.data = data;
        }
    }

    private Node parentOf(Node node){
        return node==null?null:node.parent;
    }

    private Node grandParentof(Node node){
        return parentOf(parentOf(node));
    }

    private Node leftOf(Node node){
        return node==null?null:node.left;
    }

    private Node rightOf(Node node){
        return node==null?null:node.right;
    }

    private boolean redOf(Node node){
        return node!=null && node.red;
    }

    private void setColor(Node node,boolean red){
        if (node!=null){
            node.red = red;
        }
    }

    private boolean isLeft(Node node){
        return leftOf(parentOf(node)) == node;
    }

    private void rotateLeft(Node node){
        if (node == null || rightOf(node) == null){
            return;
        }

        Node r = node.right;
        Node rl = r.left;
        Node p = node.parent;

        if (p!=null){
            if (isLeft(node)){
                p.left = node;
            }else {
                p.right = node;
            }
        }

        r.parent = p;
        r.left = node;
        node.parent = r;
        node.right = rl;
    }

    private void rotateRight(Node node){
        if (node == null || node.left == null){
            return;
        }

        Node l = node.left;
        Node lr = l.right;
        Node p  = node.parent;

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
        if (data == null){
            return;
        }
        if (this.root == null){
            this.root = new Node(data);
            this.root.red = false;
            return;
        }

        Node p = null;
        Node c = this.root;
        int i = 0;
        while (c!=null){
            p = c;
            i =  data.compareTo(c.data);
            if (i>0){
                c = c.right;
            }else if (i<0){
                c = c.left;
            }else {
                c.data = data;
                return;
            }
        }
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
        x.red = false;
        while (x!=null && redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                Node uncle = rightOf(grandParentof(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentof(x),true);
                    x = grandParentof(x);
                }else {
                    if (!isLeft(x)){
                        x = parentOf(x);
                        rotateLeft(x);
                    }

                    setColor(parentOf(x),false);
                    setColor(grandParentof(x),true);
                    rotateRight(grandParentof(x));
                }
            }else {
                Node uncle = leftOf(grandParentof(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentof(x),true);
                    x = grandParentof(x);
                }else{
                    if (isLeft(x)){
                        x = parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentof(x),true);
                    rotateLeft(grandParentof(x));
                }
            }

        }
        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
        this.root.red = false;
    }

    public void del(T data){
        if (data == null || this.root == null){
            return;
        }

        Node target = getTarget(data);

        if (target!=null){
            if (leftOf(target)!=null && rightOf(target)!=null){
                Node tmp = target.left;
                while (tmp.right!=null){
                    tmp = tmp.right;
                }
                target.data = tmp.data;
                target = tmp;
            }

            Node child = target.left==null?target.right:target.left;

            if (child!=null){
                if (target.parent==null){
                    this.root = child;
                    this.root.red = false;
                    this.root.parent = null;
                    target.left = target.right = target.parent =null;
                    target = null;
                }else {
                    Node p = target.parent;

                    if (isLeft(target)){
                        p.left = child;
                    }else {
                        p.right = child;
                    }
                    child.parent = p;
                    if (!redOf(target)){
                        fixAfterDelete(child);
                    }
                    target.left = target.right = target.parent = null;
                    target = null;
                }

            }else if (this.root == target){
                target = null;
                this.root = null;
            }else {
                Node  p= target.parent;
                if (!redOf(target)){
                    fixAfterDelete(target);
                }
                if (isLeft(target)){
                    p.left = null;
                }else {
                    p.right = null;
                }
                target.left = target.right = target.parent = null;
                target = null;

            }
        }
    }

    private void fixAfterDelete(Node x) {
        while (x!=null && !redOf(x)){
            if (isLeft(x)){
                Node s = rightOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(x),true);
                    rotateLeft(parentOf(s));
                    s = rightOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(rightOf(s))){
                        setColor(leftOf(s),false);
                        setColor(s,true);
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
                        rotateLeft(s);
                        s = leftOf(parentOf(x));
                    }
                    setColor(s,parentOf(x).red);
                    setColor(parentOf(x),false);
                    setColor(leftOf(s),false);
                    rotateRight(parentOf(x));

                }
            }
        }

        setColor(x,false);
    }

    private Node getTarget(T data) {
        Node c = this.root;
        while (c!=null){
            int i = data.compareTo(c.data);
            if (i>0){
                c = c.right;
            }else if (i<0){
                c = c.left;
            }else {
                return c;
            }
        }
        return null;
    }
}
