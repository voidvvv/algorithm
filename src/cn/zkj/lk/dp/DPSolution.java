package cn.zkj.lk.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 动态规划练习
 * Author: KJ.ZHAO
 * Date: 2021/11/12 15:06
 */
public class DPSolution {


    /**
     * 62. 不同路径
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     *
     * 问总共有多少条不同的路径？
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtwu06/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] maze = new int[m][n];

        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){

                if (y==0||x==0){
                    maze[x][y] = 1;
                    continue;
                }
                maze[x][y] = maze[x-1][y]+maze[x][y-1];

            }
        }
        return maze[m-1][n-1];
    }


    /**
     * 63. 不同路径 II
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     *
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     *
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rt1hg6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dy = new int[m][n];

        for (int x=0;x<m;x++){
            for (int y=0;y<n;y++){
                if (obstacleGrid[x][y]==1){
                    continue;
                }
                if (x==0&&y==0){
                    dy[x][y] = 1;
                    continue;
                }
                if (x==0){
                    dy[x][y] = dy[x][y-1];
                    continue;
                }
                if (y==0){
                    dy[x][y] = dy[x-1][y];
                    continue;
                }
                dy[x][y] = dy[x-1][y]+dy[x][y-1];
            }
        }
        return dy[m-1][n-1];
    }

    /**
     * 64. 最小路径和
     * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     *
     * 说明：每次只能向下或者向右移动一步。
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]dy = new int[m][n];
        for (int x=0;x<m;x++){
            for (int y =0;y<n;y++){
                if (x==0&&y==0){
                    dy[0][0] = grid[0][0];
                    continue;
                }
                if (x==0){
                    dy[x][y] = grid[x][y]+dy[x][y-1];
                    continue;
                }
                if (y==0){
                    dy[x][y] = grid[x][y]+dy[x-1][y];
                    continue;
                }
                dy[x][y] = grid[x][y] +  Math.min(dy[x-1][y],dy[x][y-1]);
            }
        }
        return dy[m-1][n-1];
    }

    /**
     * 计算最小路径同时记录路径
     * @param grid
     * @return
     */
    public int minPathSum02(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][]dy = new int[m][n];
        int[][] path = new int[m][n];
        for (int x=0;x<m;x++){
            for (int y =0;y<n;y++){
                if (x==0&&y==0){
                    dy[0][0] = grid[0][0];
                    continue;
                }
                if (x==0){
                    path[x][y] = 1;
                    dy[x][y] = grid[x][y]+dy[x][y-1];
                    continue;
                }
                if (y==0){
                    path[x][y] = 2;
                    dy[x][y] = grid[x][y]+dy[x-1][y];
                    continue;
                }
                if (dy[x-1][y]<dy[x][y-1]){
                    path[x][y] = 2;
                    dy[x][y] = grid[x][y] +dy[x-1][y];
                }else {
                    path[x][y] = 1;
                    dy[x][y] = grid[x][y] +dy[x][y-1];
                }
//                  Math.min(dy[x-1][y],dy[x][y-1]);
            }
        }
        int tx = m-1;
        int ty = n-1;
        Stack<String> stack = new Stack<>();
        while (tx>0||ty>0){
            stack.push("x:"+tx+" - y:"+ty);
            if (path[tx][ty]==1){
                ty--;
            }else if(path[tx][ty]==2){
                tx--;
            }else {
                break;
            }
        }
        while (!stack.empty()){
            System.out.println(stack.pop());
        }
        //aa
        return dy[m-1][n-1];
    }

    /**
     * 120. 三角形最小路径和
     * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
     *
     * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
     *
     * 作者：宫水三叶
     * 链接：https://leetcode-cn.com/leetbook/read/path-problems-in-dynamic-programming/rtfiiv/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> listArray[] = new ArrayList[2];
        int mod = 0;

        for (int x=0;x<triangle.size();x++){
            List<Integer> list = new ArrayList<>();
            List<Integer> integers = triangle.get(x);
            for (int y = 0; y< integers.size(); y++){
                int integer = integers.get(y);
                if (x==0){
                    list.add(integer);
                    continue;
                }
                if (y==0){

                    List<Integer> listTmp = listArray[mod];
                    int t = listTmp.get(0);
                    list.add(t+integer);

                }else if ( y<x){
                    List<Integer> listTmp = listArray[mod];
                    int t1 = listTmp.get(y-1);
                    int t2 = listTmp.get(y);
                    int tz = Math.min(t1,t2);
                    list.add(tz+integer);
                }else {
                    List<Integer> listTmp = listArray[mod];
                    list.add(listTmp.get(y-1)+integer);
                }

            }
            mod= (mod+1) % 2 ;
            listArray[mod] = list;
        }
        int min = Integer.MAX_VALUE;
        List<Integer> listTmp =listArray[mod];
        for (int x=0;x<listTmp.size();x++){
            min = Math.min(min,listTmp.get(x));
        }
        return min;
    }
}
