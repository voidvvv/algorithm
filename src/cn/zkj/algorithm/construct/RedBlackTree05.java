package cn.zkj.algorithm.construct;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhaoKaiJie
 * @Description:
 * @Date: 2022/2/13
 * @version: 01
 */
public class RedBlackTree05 <T extends Comparable<T>>{
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

    private boolean redOf(Node node){
        return node != null && node.red;
    }

    private void  setColor(Node node ,boolean red){
        if (node!=null){
            node.red = red;
        }
    }

    private boolean isLeft(Node node){
        return leftOf(parentOf(node)) == node;
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

    public void add(T data){
        if (data==null){
            return;
        }
        if (this.root==null){
            this.root = new Node(data);
            this.root.red =false;
        }

        Node p = null;
        Node c = this.root;

        while (c!=null){
            p =c;
            int i = data.compareTo(c.data);
            if (i>0){
                c = c.right;
            }else if (i<0){
                c= c.left;
            }else {
                c.data =data;
                return;
            }
        }

        int i = data.compareTo(p.data);
        Node x = new Node(data);
        if (i>0){
            p.right = x;
        }else if (i<0){
            p.left = x;
        }
        x.parent = p;
        fixAfterInsert(x);
    }

    private void fixAfterInsert(Node x) {
        if (x==null){
            return;
        }
        x.red = true;
        while (x!=null && redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                // 父节点为左
                Node uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x= grandParentOf(x);
                }else {
                    if (!isLeft(x)){
                        x= parentOf(x);
                        rotateLeft(x);
                    }
                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateRight(grandParentOf(x));
                }

            }else {
                // 父节点为右
                Node uncle = leftOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x=  grandParentOf(x);
                }else {
                    if (isLeft(x)){
                        x=  parentOf(x);
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
        setColor(this.root,false); // 根节点始终为黑
    }

    private void rotateRight(Node x) {
        if (x==null || x.left==null){
            return;
        }
        Node l = x.left;
        Node lr = l.right;
        Node p = x.parent;

        if (p!=null){
            if (isLeft(x)){
                p.left = l;
            }else {
                p.right = l;
            }
        }

        l.parent = p;
        l.right = x;
        x.parent = l;
        x.left = lr;
    }

    private void rotateLeft(Node x) {
        if (x==null && x.right == null){
            return;
        }
        Node r = x.right;
        Node rl = r.left;
        Node p = x.parent;

        if (p!=null){
            if (isLeft(x)){
                p.left = r;
            }else {
                p.right = r;
            }
        }
        r.parent = p;
        r.left = x;
        x.parent = r;
        x.right = rl;
    }

    /**
     * 比如要删除的值为7，那么就找到7这个结点，把左子树中最大的（可能是6）中的data替换在当前7结点上，然后删除6这个结点。
     * @param data
     */
    public void remove(T data){
        if (data==null||this.root==null){
            return;
        }
        Node target = getNode(data);
        if (target!=null){
            if (leftOf(target)!=null && rightOf(target)!=null){
                // 左右都有，需要找左子树最大的结点作为替补
                Node t = target.left;
                while (rightOf(t)!=null){
                    t = rightOf(t);
                }
                target.data = t.data;
                target = t;
            }
            // 现在target指向的就是待删除的结点
            // 理论上该节点现在只有一条子树，或者没有子树
            Node replace = target.left==null?target.right:target.left;
            if (replace!=null){
                // 该节点仍有子树
                if (parentOf(target)==null){
                    // 为根节点
                    this.root = replace;
                    this.root.parent = null;
                    this.root.red = false;
                    target = null;
                }else {
                    Node p = parentOf(target);
                    if (isLeft(target)){
                        p.left = replace;
                    }else {
                        p.right = replace;
                    }
                    replace.parent = p;
                    target.left = target.right = target.parent = null;
                    if (!redOf(target)){
                        fixAfterDelete(replace);
                    }
                    target = null;
                }
            }else if (parentOf(target)==null){
                this.root = null;
                target = null;
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
                    setColor(s,parentOf(s).red);
                    setColor(parentOf(s),false);
                    setColor(rightOf(s),false);
                    rotateLeft(parentOf(s));
                }
            }else {
                // 当前少结点的树为右子树
                Node s = leftOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(x),true);
                    rotateRight(parentOf(x));
                    s=  leftOf(parentOf(x));
                }
                if (!redOf(leftOf(s)) &&!redOf(rightOf(s))){
                    setColor(s,true);
                    x= parentOf(x);
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
                    rotateRight(parentOf(s));
                }
            }
        }
        setColor(x,false);
    }

    public Node getNode(T data) {
        if (data==null){
            return null;
        }
        Node s = this.root;
        while (s!=null){
            int i = data.compareTo(s.data);
            if (i>0){
                s = s.right;
            }else if (i<0){
                s = s.left;
            }else {
                return s;
            }
        }
        return s;
    }

    public void traverse(){
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> queue2 = new LinkedList<>();
        queue.offer(this.root);
        int x=1;

        while (true){
            boolean f = true;
            StringBuilder print = new StringBuilder(String.format("第%s层",x++));
            if (!queue.isEmpty()){
                while (!queue.isEmpty()){
                    Node poll = queue.poll();
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
                    Node poll = queue2.poll();
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
        RedBlackTree05<Integer> tree = new RedBlackTree05<Integer>();
        int[] arr  = new int[]{1,2,3,4,9,0,-2,63,-20};
        for (int x=0;x<arr.length;x++){
            tree.add(arr[x]);
        }
        System.out.println("========================");
        tree.traverse();
        System.out.println("========================");
        for (int x=0;x<arr.length;x++){
            tree.remove(arr[x]);
        }
        System.out.println("end");
    }
}
