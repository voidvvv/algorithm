package cn.zkj.lk;

//1315. 祖父节点值为偶数的节点和

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
给你一棵二叉树，请你返回满足以下条件的所有节点的值之和：

该节点的祖父节点的值为偶数。（一个节点的祖父节点是指该节点的父节点的父节点。）
如果不存在祖父节点值为偶数的节点，那么返回 0 。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/sum-of-nodes-with-even-valued-grandparent
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
输入：root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
输出：18
解释：图中红色节点的祖父节点的值为偶数，蓝色节点为这些红色节点的祖父节点。


 */
public class SumEvenGrandparent {
    public static void main(String[] args) {
        List<Integer> ret = Arrays.stream(new int[6]).boxed().collect(Collectors.toList());
        IntStream stream = Arrays.stream(new int[6]);

        Stream<Integer> boxed = stream.boxed();

        Collector<Object, ?, List<Object>> objectListCollector = Collectors.toList();
        boxed.collect(objectListCollector);



        for (int x=0;x<10;x++){
            int random =(int)( Math.random()*10);
            System.out.println(random);
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        return sum(root,0);
    }

    public int sum(TreeNode root,int flag){
        return 0;


    }

    /*public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int length = grid.length;
        int length1 = grid[0].length;

        int s=length*length1;
        int m=k%s;
        int n=k/length1;

        int[] arr= new int[s];



    }*/
}
