package cn.zkj.algorithm.construct;

import cn.zkj.algorithm.construct.listnode.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname RedBlackTree21
 * @Description
 * @Date 2022/6/8 14:44
 * @Created by zkj
 */
public class RedBlackTree21 <T extends Comparable<T>>{
    private Node<T> root;

    private Node<T> parentOf(Node<T> node ){
        return node == null? null:node.parent;
    }

    private Node<T> grandParentOf(Node<T> node){
        return parentOf(parentOf(node));
    }

    private Node<T> leftOf(Node<T> node){
        return node == null? null:node.left;
    }

    private Node<T> rightOf(Node<T> node){
        return node == null? null:node.right;
    }

    private void setColor(Node<T> node,boolean red){
        if (node!=null){
            node.red = red;
        }
    }

    private boolean redOf(Node<T> node){
        return node!=null && node.red;
    }

    private boolean isLeft(Node<T> node){
        return leftOf(parentOf(node)) == node;
    }

    private boolean isRoot(Node<T> node){
        return parentOf(node) == null;
    }

    private void rotateLeft(Node<T> node){
        if (node == null || rightOf(node) == null){
            return;
        }

        Node<T> r = node.right;
        Node<T> rl = r.left;
        Node<T> p = parentOf(node);

        if (p!=null){
            if (isLeft(node)){
                p.left = r;
            }else {
                p.right = r;
            }
        }

        node.right = rl;
        node.parent = r;

        r.left = node;
        r.parent = p;

        if (rl!=null){
            rl.parent = node;
        }

        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
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

        node.parent = l;
        node.left = lr;

        l.parent = p;
        l.right = node;

        if (lr!=null){
            lr.parent = node;
        }

        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
    }

    public void  add(T data){
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

        Node<T> x= new Node<>(data);
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
                    x = this.root;
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
                        x= parentOf(x);
                        rotateRight(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateLeft(grandParentOf(x));
                    x = this.root;
                }
            }

        }

        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
        setColor(this.root,false);
    }

    public void del(T data){
        if (this.root == null || data ==null){
            return;
        }
        
        Node<T> target = findTartgetNode(data);
        if (target == null){
            return;
        }
        if (leftOf(target)!=null && rightOf(target)!=null){
            Node<T> tmp = target.left;
            while (rightOf(tmp)!=null){
                tmp = rightOf(tmp);
            }
            target.data = tmp.data;
            target = tmp;
        }
        
        Node<T> child = leftOf(target) == null? rightOf(target): leftOf(target);
        
        if (child!=null){
            if (isRoot(target)){
                this.root = child;
                this.root.parent = null;
                setColor(this.root,false);
                return;
            }else {
                Node<T> p = parentOf(target);
                if (isLeft(target)){
                    p.left = child;
                }else {
                    p.right = child;
                }
                
                child.parent = p;
                
                target.left = target.right = null;
                if (!redOf(target)){
                    fixAfterDelete(child);
                }
                target = null;
            }
        }else if (isRoot(target)){
            this.root = null;
            target = null;
        }else {
            if (!redOf(target)){
                fixAfterDelete(target);
            }
            Node<T> p = parentOf(target);
            if (isLeft(target)){
                p.left = child;
            }else {
                p.right = child;
            }
            target = null;
        }
    }

    private void fixAfterDelete(Node<T> x) {
        while (x!=null && !isRoot(x) && !redOf(x)){
            if (isLeft(x)){
                Node<T> s=  rightOf(parentOf(x));
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
                        rotateRight(s);
                        s = rightOf(parentOf(x));
                    }
                    setColor(s,parentOf(x).red);
                    setColor(parentOf(x),false);
                    setColor(rightOf(s),false);
                    rotateLeft(parentOf(x));
                    x = this.root;
                }
            }else {
                Node<T> s = leftOf(parentOf(x));
                if (redOf(s)){
                    setColor(parentOf(x),true);
                    setColor(s,false);
                    rotateRight(parentOf(x));
                    s = leftOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) && !redOf(rightOf(s))){
                    setColor(s,true);
                    x = parentOf(x);
                }else {
                    if (!redOf(leftOf(x))){
                        setColor(s,true);
                        setColor(rightOf(s),false);
                        rotateLeft(s);
                        s = leftOf(parentOf(x));
                    }

                    setColor(s,parentOf(x).red);
                    setColor(parentOf(x),false);
                    setColor(leftOf(x),false);
                    rotateRight(parentOf(x));
                    x = this.root;
                }
            }
        }

        setColor(x,false);
    }

    private Node<T> findTartgetNode(T data) {
        Node<T> r = this.root;
        
        while (r!=null){
            int i = data.compareTo(r.data);
            if(i > 0){
                r=r.right;
            }else if (i<0){
                r = r.left;
            }else {
                return r;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        RedBlackTree21<Integer> tree = new RedBlackTree21<>();

        int[] arrs = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("======add start========");
        for(int x=0;x<arrs.length;x++){
            tree.add(arrs[x]);

        }
        printTree(tree.root);
        System.out.println("=====add end=====");
        System.out.println("========del start========");
        for(int x=0;x<arrs.length;x++){
            tree.del(arrs[x]);
            printTree(tree.root);
        }
        printTree(tree.root);
        System.out.println("========del end========");
    }


    private static void printTree(Node<Integer> root) {
        System.out.println("print");
        if (root == null){
            System.out.println("null");
            return;
        }
        Queue<Node<Integer>> queue = new LinkedList<>();

        queue.offer(root);
        int rowNum = 1;
        while (!queue.isEmpty()){
            int size = queue.size();
            System.out.printf("第 %s 行 ",rowNum++);
            for(int x=0;x<size;x++){
                Node<Integer> poll = queue.poll();
                if (poll == null){
                    System.out.print("null\t");
                }else {
                    System.out.printf("%s %s",poll.data,poll.red);
                    System.out.print("\t");
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
            }
            System.out.println();
        }
        System.out.println("print  end");
    }
}
