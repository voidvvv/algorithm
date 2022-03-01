package cn.zkj.algorithm.construct;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @Classname RedBlackTree13
 * @Description
 * @Date 2022/2/25 23:17
 * @Created by zkj
 */
public class RedBlackTree13 <T extends Comparable<T>>{
    private Node root;
    class Node{
        boolean red;
        Node left;
        Node right;
        Node parent;
        T data;

        public Node(T data) {
            this.data = data;
            this.red = true;
        }
    }

    private Node parentOf(Node node){
        return node==null?null:node.parent;
    }

    private Node grandParentOf(Node node){
        return parentOf(parentOf(node));
    }

    private Node leftOf(Node node){
        return node==null?null:node.left;
    }

    private Node rightOf(Node node){
        return node == null?null:node.right;
    }

    private boolean redOf(Node node){
        return node!=null && node.red;
    }

    private boolean isLeft(Node node){
        return leftOf(parentOf(node)) == node;
    }

    private void setColor(Node node,boolean red){
        if (node!=null){
            node.red = red;
        }
    }

    private void rotateLeft(Node node){
        if (node == null || node.right==null){
            return;
        }
        Node r = node.right;
        Node p = node.parent;
        Node rl = r.left;

        if (p!=null){
            if (isLeft(node)) {
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

    private void rotateRight(Node node){
        if (node==null || node.left == null){
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
            p =c;
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
        x.red = true;
        while (x!=null && redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                Node unlce = rightOf(grandParentOf(x));
                if (redOf(unlce)){
                    setColor(parentOf(x),false);
                    setColor(unlce,false);
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
            } else {
                Node uncle = leftOf(grandParentOf(x));
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

        Node target = getTarget(data);
        if (target!=null){
            if (leftOf(target)!=null && rightOf(target)!=null){
                Node tmp = leftOf(target);
                while (rightOf(tmp)!=null){
                    tmp = rightOf(tmp);
                }
                target.data = tmp.data;
                target = tmp;
            }

            Node child = target.left == null?target.right: target.left;

            if (child!=null){
                if (parentOf(target)==null){
                    this.root = child;
                    this.root.red = false;
                    this.root.parent = null;
                    target.left = target.right = target.parent = null;
                    target = null;
                }else {
                    Node p = parentOf(target);
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

            }else if (target.parent==null){
                this.root = null;
                target.left = target.right = target.parent = null;
                target = null;
            }else {
                Node p = parentOf(target);
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
                    setColor(parentOf(s),true);
                    rotateLeft(parentOf(x));
                    s = rightOf(parentOf(x));
                }
                if (!redOf(rightOf(s)) && !redOf(leftOf(s))){
                    setColor(s,true);
                    x= parentOf(x);
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
                    x = root;
                }
            }else {
                Node s = leftOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(s),true);
                    rotateLeft(parentOf(x));
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
                    setColor(s,parentOf(s).red);
                    setColor(leftOf(s),false);
                    setColor(parentOf(s),false);
                    rotateRight(parentOf(s));
                    x = root;
                }
            }

        }
        setColor(x,false);
    }

    private Node getTarget(T data) {
        Node c= this.root;
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
    public void traverse(){
        Queue<RedBlackTree13.Node> queue = new LinkedList<>();
        Queue<RedBlackTree13.Node> queue2 = new LinkedList<>();
        queue.offer(this.root);
        int x=1;

        while (true){
            boolean f = true;
            StringBuilder print = new StringBuilder(String.format("第%s层",x++));
            if (!queue.isEmpty()){
                while (!queue.isEmpty()){
                    RedBlackTree13.Node poll = queue.poll();
                    if (poll==null){
                        print.append("null\t");
                    }else {
                        f= false;
                        print.append(poll.data);
                        print.append(" ");
                        print.append(poll.red).append("\t");
                        queue2.offer(poll.left);
                        queue2.offer(poll.right);
                    }
                }
            }else if (!queue2.isEmpty()){
                while (!queue2.isEmpty()){
                    RedBlackTree13.Node poll = queue2.poll();
                    if (poll==null){
                        print.append("null\t");
                    }else {
                        f= false;
                        print.append(poll.data);
                        print.append(" ");
                        print.append(poll.red).append("\t");
                        queue.offer(poll.left);
                        queue.offer(poll.right);
                    }
                }
            }

            if (f){
                break;
            }
            System.out.println(print.toString());
        }

    }

    public static void main(String[] args) {
        RedBlackTree13<Integer> tree = new RedBlackTree13<Integer>();
        int[] arr  = new int[]{1,2,3,4,9,0,-2,63,-20};
        for (int x=0;x<arr.length;x++){
            int t = arr[x];
            tree.add(arr[x]);
        }
        System.out.println("========================");
        tree.traverse();
        System.out.println("========================");
        for (int x=0;x<arr.length;x++){
            tree.del(arr[x]);
            System.out.println("===========del:"+arr[x]+":=============");
            tree.traverse();
            System.out.println("============del end============");
        }
        System.out.println("end");
    }
}
