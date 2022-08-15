package cn.zkj.algorithm.construct;

/**
 * @Classname RedBlackTree22
 * @Description
 * @Date 2022/8/7 18:41
 * @Created by zkj
 */
public class RedBlackTree22 <T extends Comparable<T>>{

    private Node root;

    private Node parentOf(Node node){
        return node == null? null:node.parent;
    }

    private Node rightOf(Node node){
        return node == null? null:node.right;
    }

    private Node leftOf(Node node){
        return node == null? null:node.left;
    }

    private Node grandParentOf(Node node){
        return parentOf(parentOf(node));
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

    private boolean isRoot(Node node){
        return parentOf(node) == null;
    }

    private void  rotateLeft(Node node){
        if (node == null || node.right == null){
            return;
        }
        Node p = parentOf(node);
        Node r = node.right;
        Node rl = r.left;

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

        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
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
        l.right = node;

        node.left = lr;
        node.parent = l;

        if (lr!=null){
            lr.parent = node;
        }


        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
    }

    public void add(T data){
        if (data == null){
            return;
        }

        if(this.root == null){
            this.root = new Node(data);
            this.root.red = false;
            return;
        }

        Node p = null;
        Node c = this.root;

        while (c!=null){
            p = c;
            if (data.compareTo(c.val)>0){
                c = c.right;
            }else if (data.compareTo(c.val)<0){
                c = c.left;
            }else {
                c.val = data;
                return;
            }
        }

        int i = data.compareTo(p.val);
        Node x = new Node(data);
        if (i>0){
            p.right = x;
        }else {
            p.left = x;
        }
        x.parent = p;

        fixAfterInsert(x);
    }

    private void fixAfterInsert(Node x) {
        x.red = true;
        while (x!=null && redOf(parentOf(x))){
            if (isLeft(parentOf(x))){
                Node uncle = rightOf(grandParentOf(x));
                if (redOf(uncle)){
                    setColor(parentOf(x),false);
                    setColor(uncle,false);
                    setColor(grandParentOf(x),true);
                    x= grandParentOf(x);
                }else {
                    if (!isLeft(x)){
                        x = parentOf(x);
                        rotateLeft(x);
                    }

                    setColor(parentOf(x),false);
                    setColor(grandParentOf(x),true);
                    rotateRight(grandParentOf(x));
                    x= this.root;
                }
            }else {
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
                    x = this.root;
                }
            }

        }

        while (parentOf(this.root)!=null){
            this.root = parentOf(this.root);
        }
        this.root.red = false;
    }

    public void del(T data){
        if (this.root == null || data == null){
            return;
        }
        Node target = findTargetNode(data);
        if (target != null){
            if (leftOf(target)!=null && rightOf(target)!=null){
                Node tmp = target.left;
                while (rightOf(tmp)!=null){
                    tmp = rightOf(tmp);
                }
                target.val = tmp.val;
                target = tmp;
            }

            Node child = leftOf(target) == null? leftOf(target) : rightOf(target);

            if (child!=null){
                Node  p = parentOf(target);
                if (p == null){
                    this.root = child;
                    this.root.red = false;
                    this.root.parent = null;
                    target = target.left = target.right = null;
                    return;
                }

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
            }else if (isRoot(target)){
                this.root = null;
                target = target.left = target.right = null;
                return;
            }else {
                Node  p = parentOf(target);

                if (!redOf(target)){
                    fixAfterDelete(target);
                }
                if (isLeft(target)){
                    p.left = null;
                }else {
                    p.right = null;
                }
                target = target.left = target.right = null;
            }
        }
    }

    private void fixAfterDelete(Node x) {
        while (x!=null &&!isRoot(x) &&  !redOf(x)){
            if (isLeft(x)){
                Node s = rightOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(x),true);
                    rotateLeft(parentOf(x));
                    s = rightOf(parentOf(x));
                }

                if (!redOf(rightOf(s)) &&!redOf(leftOf(s))){
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
                    setColor(parentOf(x),true);
                    setColor(rightOf(s),false);
                    rotateLeft(parentOf(x));
                    x = this.root;
                }
            }else {
                Node s = leftOf(parentOf(x));
                if (redOf(s)){
                    setColor(s,false);
                    setColor(parentOf(x),true);
                    rotateRight(parentOf(x));
                    s= leftOf(parentOf(x));
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
                    setColor(parentOf(x),true);
                    setColor(leftOf(s),false);
                    rotateRight(parentOf(x));
                    x = this.root;
                }
            }

        }
        setColor(x,false);
    }

    private Node findTargetNode(T data) {
        Node c= this.root;
        while (c !=null){
            int i= data.compareTo(c.val);
            if (i>0){
                c = c.right;
            }else if (i<0){
                c = c.left;
            }else {
                return  c;
            }
        }
        return null;
    }

    class Node {
        Node parent;
        boolean red;
        T val;
        Node left;
        Node right;

        public Node(T val) {
            this.val = val;
            this.red = true;
        }
    }
}
