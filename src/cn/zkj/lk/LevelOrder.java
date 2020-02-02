package cn.zkj.lk;
//429. N叉树的层序遍历

import java.util.ArrayList;
import java.util.List;

/*

给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。

例如，给定一个 3叉树 :

 



 

返回其层序遍历:

[
     [1],
     [3,2,4],
     [5,6]
]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LevelOrder {
    public static void main(String[] args) {
        Node node =new Node(1);
        List<Node> list1 =new ArrayList<>();

        Node node3 =new Node(3);

        List<Node> list2 =new ArrayList<>();

        node3.children=list2;
        list2.add(new Node(5));
        list2.add(new Node(6));

        node.children=list1;
        list1.add(node3);
        list1.add(new Node(2));
        list1.add(new Node(4));

        LevelOrder levelOrder = new LevelOrder();

        List<List<Integer>> lists = levelOrder.levelOrder(node);

        System.out.println("=======");
        System.out.println(lists);

    }
    public List<List<Integer>> levelOrder(Node root) {

        List<Integer> first = new ArrayList<>();
        first.add(root.val);
        List<List<Integer>> result = new ArrayList<>();
        result.add(first);
        findOrder(root.children,result,1);


        return result;
    }

    public void findOrder(List<Node> root,List<List<Integer>> result,int n){
        if (root==null){
            return;
        }


        List<Integer> integers = null;
        if (result.size()>=n+1){
            integers=result.get(n);
        }else {
            integers=new ArrayList<>();
            result.add(integers);
        }

        for (Node node:root){
            integers.add(node.val);
            findOrder(node.children,result,n+1);
        }


    }


}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }


};