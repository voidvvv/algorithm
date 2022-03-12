package cn.zkj.algorithm.construct;

import cn.zkj.algorithm.construct.listnode.Node;
import cn.zkj.algorithm.construct.listnode.TreeNodeUtils;

/**
 * @Classname RedBlackTree16
 * @Description
 * @Date 2022/3/12 22:57
 * @Created by zkj
 */
public class RedBlackTree16 <T extends Comparable<T>>{

    private Node<T> root;

    private Node<T> leftOf(Node<T> node){
        return node == null?null:node.left;
    }

    private Node<T> parentOf(Node<T> node){
        return node == null? null:node.parent;
    }

    private Node<T> grandParentOf(Node<T> node){
        return parentOf(parentOf(node));
    }

    private Node<T> rightOf(Node<T> node){
        return node == null?null:node.right;
    }

    private boolean redOf(Node<T> node){
        return node !=null && node.red;
    }

    private void setColor(Node<T> node,boolean red){
        if (node!=null){
            node.red =red;
        }
    }

    private boolean isLeft(Node<T> node){
        return leftOf(parentOf(node)) == node;
    }

    private void rotateLeft(Node<T> node){
        if (node == null|| node.right == null){
            return;
        }

        Node<T> p = node.parent;
        Node<T> r = node.right;
        Node<T> rl = r.left;

        if (p!=null){
            if (isLeft(node)){
                p.left = r;
            }else {
                p.right = r;
            }
        }

        r.parent = p;
        if (rl!=null){
            rl.parent = node;
        }

        r.left = node;
        node.right = rl;
        node.parent=r;
    }

    private void rotateRight(Node<T> node){
        if (node == null || node.left == null){
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

        if (lr!=null){
            lr.parent = node;
        }

        l.right = node;
        node.parent = l;
        node.left = lr;

    }

    public void add(T data){
        if (data == null){
            return;
        }

        if (this.root == null){
            this.root = new Node<>(data);
            this.root.red = false;
            return;
        }

        Node<T> p = null;
        Node<T> c= this.root;
        int i = 0;
        while (c!=null){
            p=c;
            i = data.compareTo(c.data);
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
        setColor(this.root,false);
    }

    public void del(T data){
        if (data == null || this.root == null){
            return;
        }
        Node<T> target = getTargetNode(data);
        if (target!=null){
            if (leftOf(target)!=null && rightOf(target)!=null){
                Node<T> tmp = target.left;
                while (rightOf(tmp)!=null){
                    tmp = rightOf(tmp);
                }
                target.data = tmp.data;
                target = tmp;
            }
            Node<T> child = target.left ==null?target.right:target.left;

            if (child!=null){
                if (target.parent == null){
                    this.root = child;
                    this.root.red =false;
                    this.root.parent = null;
                    target.left = target.right = target.parent = null;
                    target = null;
                    return;
                }else {
                    Node<T> p = target.parent;
                    if (isLeft(target)){
                        p.left = child;
                    }else {
                        p.right = child;
                    }
                    child.parent = p;
                    target.left = target.right = target.parent = null;
                    if (!redOf(target)){
                        fixAfterDelete(child);
                    }
                    target = null;
                    return;
                }

            }else if (target.parent == null){
                this.root = null;
                target.left = target.right = target.parent = null;
                target = null;
            }else {
                Node<T> p = target.parent;
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

    private void fixAfterDelete(Node<T> x) {
        while (x!=null && !redOf(x)){
            if (isLeft(x)){
                Node<T> s = rightOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(x),true);
                    rotateLeft(parentOf(x));
                    s = rightOf(parentOf(x));
                }

                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(rightOf(s))){
                        setColor(leftOf(s),false);
                        setColor(s,true);
                        rotateRight(parentOf(s));
                        s = rightOf(parentOf(x));
                    }
                    setColor(s,parentOf(x).red);
                    setColor(parentOf(s),false);
                    setColor(rightOf(s),false);
                    rotateLeft(parentOf(s));
                    x = this.root;
                }
            }else {
                Node<T> s = leftOf(parentOf(x));

                if (redOf(s)){
                    setColor(s, false);
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
                    x = this.root;
                }
            }
        }
        setColor(x,false);
    }

    private Node<T> getTargetNode(T data) {
        Node<T> c= this.root;
        while (c!=null){
            int i = data.compareTo(c.data);
            if (i == 0){
                return c;
            }else if (i>0){
                c = c.right;
            }else {
                c = c.left;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RedBlackTree16<Integer> tree = new RedBlackTree16<Integer>();
        int[] arr  = new int[]{1,2,3,4,9,0,-2,63,-20};
        for (int x=0;x<arr.length;x++){
            int t = arr[x];
            tree.add(arr[x]);
        }
        System.out.println("========================");
        TreeNodeUtils.traverse(tree.root);
        System.out.println("========================");
        for (int x=0;x<arr.length;x++){

            tree.del(arr[x]);
            System.out.println("===del:"+arr[x]+"===");
            TreeNodeUtils.traverse(tree.root);
            System.out.println("======");
        }

        System.out.println("end");
    }
}
