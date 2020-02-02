package cn.zkj.algorithm.mytree;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree =new BinaryTree();

        BinaryTreeNode bt1 =new BinaryTreeNode(1,"aaaa");
        BinaryTreeNode bt2 =new BinaryTreeNode(2,"aaaa");
        BinaryTreeNode bt3 =new BinaryTreeNode(3,"aaaa");
        BinaryTreeNode bt4 =new BinaryTreeNode(4,"aaaa");
        BinaryTreeNode bt5 =new BinaryTreeNode(5,"aaaa");
        BinaryTreeNode bt6 =new BinaryTreeNode(6,"aaaa");
        BinaryTreeNode bt7 =new BinaryTreeNode(7,"aaaa");

        bt1.left=bt2;
        bt1.right=bt3;

        bt2.left=bt4;
        bt2.right=bt5;

        bt3.left=bt6;
        bt3.right=bt7;

        binaryTree.setTreeNode(bt1);
        binaryTree.midPrint();
//        binaryTree.delP(1);
        System.out.println("=============");
        binaryTree.prePrint();
    }


}
class BinaryTree{
    private BinaryTreeNode treeNode;

    public void setTreeNode(BinaryTreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public void prePrint(){
        if (this.treeNode!=null){
            this.treeNode.prePrint();
        }else {
            System.out.println("空的遍历尼玛币啊");
        }
    }
    public void midPrint(){
        if (this.treeNode!=null){
            this.treeNode.midPrint();
        }else {
            System.out.println("空的遍历尼玛币啊");
        }
    }
    public void postPrint(){
        if (this.treeNode!=null){
            this.treeNode.postPrint();
        }else {
            System.out.println("空的遍历尼玛币啊");
        }
    }

    public void delP(int val){
        if (this.treeNode!=null&&this.treeNode.val==val){
            this.treeNode=null;
            return;
        }
        this.treeNode.delPoint(val);
    }
}

class BinaryTreeNode{
    public int val;
    public String name;

    public BinaryTreeNode left;
    public BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int val, String name) {
        this.val = val;
        this.name = name;
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "val=" + val +
                ", name='" + name + '\'' +
                '}';
    }

    public void prePrint(){
        System.out.println(this);
        if (this.left!=null){
            this.left.prePrint();
        }
        if (this.right!=null){
            this.right.prePrint();
        }

    }
    public void midPrint(){

        if (this.left!=null){
            this.left.midPrint();
        }
        System.out.println(this);

        if (this.right!=null){
            this.right.midPrint();
        }

    }
    public void postPrint(){

        if (this.left!=null){
            this.left.postPrint();
        }


        if (this.right!=null){
            this.right.postPrint();
        }
        System.out.println(this);
    }

    //删除二叉树的节点

    public void delPoint(int val){
        if (this.left!=null&&this.left.val==val){
            this.left=null;
            return;
        }
        if (this.right!=null&&this.right.val==val){
            this.right=null;
            return;
        }
        if (this.left!=null){
            this.left.delPoint(val);
        }
        if (this.right!=null){
            this.right.delPoint(val);
        }
    }
}
