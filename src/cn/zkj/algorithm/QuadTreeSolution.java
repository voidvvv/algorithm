package cn.zkj.algorithm;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @Classname QuadTreeSolution
 * @Description
 * @Date 2022/4/29 11:52
 * @Created by zkj
 */
public class QuadTreeSolution {

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);
//        semaphore.acquire();
        semaphore.release();

        IntConsumer i = new IntConsumer() {
            @Override
            public void accept(int value) {

            }
        };
//        i.accept();
        QuadTreeSolution q1 = new QuadTreeSolution();
        q1.construct(new int[][]{{0,1},{1,0}});
    }

    public Node construct(int[][] grid) {
        int n = grid.length;
        return callBack(grid,0,n-1,0,n-1);
    }

    public Node callBack(int[][] grid,int yStart,int yEnd,int xStart,int xEnd){
        Node cur = new Node();

        if(yStart == yEnd && xStart == xEnd){
            cur.val = (grid[yStart][xStart] == 1);
            cur.isLeaf = true;
            return cur;
        }
        boolean curVal = grid[yStart][xStart]==1;
        boolean curLeaf = true;
        int yLimit = (yStart+yEnd)/2;
        int xLimit = (xStart+xEnd)/2;

        Node topRight = callBack(grid,yStart,yLimit,xLimit+1,xEnd);
        curLeaf = curLeaf&&topRight.isLeaf && (topRight.val == curVal);
        Node topLeft = callBack(grid,yStart,yLimit,xStart,xLimit);
        curLeaf = curLeaf&&topLeft.isLeaf && (topLeft.val == curVal);
        Node bottomLeft = callBack(grid,yLimit+1,yEnd,xStart,xLimit);
        curLeaf = curLeaf&&bottomLeft.isLeaf && (bottomLeft.val == curVal);
        Node bottomRight = callBack(grid,yLimit+1,yEnd,xLimit+1,xEnd);
        curLeaf = curLeaf&&bottomRight.isLeaf && (bottomRight.val == curVal);

        if(curLeaf){
            cur.val = (grid[yStart][xStart] == 1);
            cur.isLeaf = true;
            return cur;
        }else{
            cur.topRight = topRight;
            cur.topLeft = topLeft;
            cur.bottomLeft = bottomLeft;
            cur.bottomRight = bottomRight;
            cur.isLeaf = false;
            return cur;
        }

    }

}
