package cn.zkj.algorithm.construct;

import cn.zkj.algorithm.construct.listnode.Node;

/**
 * @Classname RedBlackTree19
 * @Description
 * @Date 2022/4/10 20:03
 * @Created by zkj
 */
public class RedBlackTree19 <T extends Comparable<T>>{
    private Node<T> root;

    private Node<T> parentOf(Node<T> node){
        return node == null? null :node.parent;
    }

    private Node<T> grandParentOf(Node<T> node){
        return parentOf(parentOf(node));
    }

    private Node<T> leftOf(Node<T> node){
        return node == null?null :node.left;
    }

    private Node<T> rightOf(Node<T> node){
        return node == null?null:node.right;
    }

    private boolean redOf(Node<T> node){
        return node!=null && node.red;
    }

    private void setColor(Node<T> node,boolean red){
        if (node!=null){
            node.red = red;
        }
    }

    private boolean isLeft(Node<T> node){
        return leftOf(parentOf(node)) == node;
    }

    private void rotateLeft(Node<T> node){
        if (node==null || node.right == null){
            return;
        }

        Node<T> r = node.right;
        Node<T> rl = r.left;
        Node<T> p = node.parent;

        if (p!=null){
            if (isLeft(node)){
                p.left = r;
            }else {
                p.right = r;
            }
        }

        r.parent = p;
        r.left = node;
        node.parent = r;
        node.right = rl;
        if (rl!=null){
            rl.parent = node;
        }
    }

    private void rotateRight(Node<T> node){
        if (node ==null || node.left == null){
            return;
        }
        Node<T> l = node.left;
        Node<T> lr = l.right;
        Node<T> p = node.parent;

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

        if (lr!=null){
            lr.parent = node;
        }
    }

    public void add(T data){
        if (data == null){
            return;
        }

        if (this.root == null){
            this.root = new Node<>(data);
            this.root.red= false;
            return;
        }

        Node<T> p = null;
        Node<T> c = this.root;
        int i = data.compareTo(c.data);
        while (c!=null){
            p=c;
            if (i>0){
                c = c.right;
            }else if (i<0){
                c = c.left;
            }else {
                c.data = data;
                return;
            }
        }

        Node<T> x = new Node<>(data);
        x.parent = p;
        if (i>0){
            p.right = x;
        }else {
            p.left = x;
        }
        fixAfterInsert(x);
    }

    private void fixAfterInsert(Node<T> x) {
        x.red = true;
        while (x!=null && redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                Node<T> uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (!isLeft(x)){
                        x = parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateRight(grandParentOf(x));
                }
            }else {
                Node<T> uncle = leftOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x = grandParentOf(x);
                }else {
                    if (isLeft(x)){
                        x = parentOf(x);
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

    public void del(T data){
        if (data == null || this.root == null){
            return;
        }
        Node<T> target = findTarget(data);
        if (target!=null){
            if (leftOf(target)!=null && rightOf(target)!=null){
                Node<T> t = target.left;
                while (rightOf(target)!=null){
                    t = rightOf(t);
                }
                target.data = t.data;
                target = t;
            }

            Node<T> child = target.left == null ?target.right:target.left;

            if (child!=null){
                if (target.parent==null){

                }else {

                }
            }
        }
    }

    private Node<T> findTarget(T data) {
        Node<T> r = this.root;
        while (r!=null){
            int i = data.compareTo(r.data);
            if (i>0){
                r= r.right;
            }else if (i<0){
                r = r.left;
            }else {
                return r;
            }
        }
        return null;
    }
}
