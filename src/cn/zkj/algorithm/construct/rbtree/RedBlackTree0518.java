package cn.zkj.algorithm.construct.rbtree;

public class RedBlackTree0518 {
    class Node {
        int val;
        boolean red;
        Node left;
        Node right;
        Node parent;

        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
            this.parent = null;
            red = true;
        }
    }

    private Node root;

    public Node parentOf(Node node) {
        return node == null ? null : node.parent;
    }

    public Node leftOf(Node node) {
        return node == null ? null : node.left;
    }

    public Node rightOf(Node node) {
        return node == null ? null : node.right;
    }

    public boolean redOf(Node node) {
        return node != null && node.red;
    }

    public boolean isLeft (Node node) {
        return leftOf(parentOf(node)) == node;
    }

    public void setRed(Node node, boolean red) {
        if (node != null) {
            node.red = red;
        }
    }

    /**
     * 将右节点设置为父节点，当前节点变为右节点的左子节点
     * @param node
     */
    public void rotateLeft (Node node) {
        Node parent = parentOf(node);
        Node r = rightOf(node);
        Node rl = leftOf(r);

        if (parent != null) {
            if (isLeft(node)) {
                parent.left = r;
            } else  {
                parent.right = r;
            }
        }

        r.parent = parent;
        r.left = node;

        node.parent = r;
        node.right = rl;
    }

    /**
     * 将左节点设置为父节点，当前节点为左节点的右子节点
     * @param node
     */
    public void rotateRight (Node node) {
        Node p = parentOf(node);
        Node l = leftOf(node);
        Node lr = rightOf(l);

        if (p != null) {
            if (isLeft(node)) {
                p.left = l;
            } else {
                p.right = l;
            }
        }

        l.parent = p;
        l.right = node;

        node.parent = l;
        node.left = lr;
    }

    public void add (int s) {
        if (root == null) {
            root = new Node(s);
            root.red = false;
            return;
        }

        Node pre = null;
        Node c = root;
        while (c != null) {
            if (s == c.val) {
                return;
            }
            pre = c;
            if (s > c.val) {
                c = c.right;
            } else {
                c = c.left;
            }
        }
        Node newNode = new Node(s);
        if (s > pre.val) {
            pre.right = newNode;
        } else {
            pre.left = newNode;
        }

        fixAfterInsert(newNode);
    }

    private void fixAfterInsert(Node x) {
        x.red = true; // set new node to red first
        while (x != null && redOf(parentOf(x))) {
            // if x is not null and parent is red
            if (isLeft(parentOf(x))) {
                Node uncle = rightOf(parentOf(x));
                if (redOf(uncle)) { // uncle and parent are both red, then just need to make them black
                    setRed(uncle, false);
                    setRed(parentOf(x), false);
                    setRed(parentOf(parentOf(x)), true);
                    x= parentOf(parentOf(x));
                }
            }
        }

    }
}
