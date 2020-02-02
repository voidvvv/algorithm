package cn.zkj.algorithm.huffman;

import java.util.*;

public class HuffmanDemo {
    public static void main(String[] args) {
        int[]arr ={101,102,103,104,105,106,107,108,109};
//        createHuffmanTreeS(arr);
//        createHuffmanTreeL(arr);

        int a=2;
        for (int x=0;x<32;x++){
            a=a<<1;
            System.out.println("zheshi "+(x+2)+"::::"+a);
        }

        System.out.println(a);
    }

    public static void reverse(int[]arr){
        int n=arr.length/2;

        while (n>0){
            for (int x=n;x<n*2;x++){
                for (int y=x;y<arr.length;y+=n){
                    int value=arr[y];
                    int index=y-n;

                    while (index>=0&&arr[index]<value){
                        arr[index+n]=arr[index];
                        index-=n;
                    }
                    arr[index+n]=value;
                }
            }
            n/=2;
        }
    }

    public static void createHuffmanTreeS(int[]arr){
        System.out.println("栈方法：");
        reverse(arr);

        Stack<Node> stack =new Stack<>();
        for (int x=0;x<arr.length;x++){
            stack.push(new Node(arr[x]));
        }
        while (stack.size()>1){
            Node left = stack.pop();
            Node right = stack.pop();

            Node parent =new Node(left.value+right.value);
            parent.left=left;
            parent.right=right;

            stack.push(parent);
        }
        Node pop = stack.pop();
        prePrint(pop);

    }

    public static void createHuffmanTreeL(int[]arr){
        System.out.println("集合方法");
        Arrays.sort(arr);
        List<Node> list=new ArrayList<>();
        for (int x=0;x<arr.length;x++){
            list.add(new Node(arr[x]));
        }

        while (list.size()>1){
            Node left = list.get(0);
            Node right=list.get(1);

            list.remove(left);
            list.remove(right);

            Node parent=new Node(left.value+right.value);
            parent.left=left;
            parent.right=right;

            list.add(parent);
            Collections.sort(list);
        }

        prePrint(list.get(0));
    }

    public static void prePrint(Node root){
        System.out.println(root);

        if (root.left!=null){
            prePrint(root.left);
        }
        if (root.right!=null){
            prePrint(root.right);
        }
    }
}

class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int v){
        this.value=v;
    }
    @Override
    public int compareTo(Node o) {
        return this.value-o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
